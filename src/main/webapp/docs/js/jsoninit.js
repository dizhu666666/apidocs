/*jslint white: true, devel: true, onevar: true, browser: true, undef: true, nomen: true, regexp: true, plusplus: false, bitwise: true, newcap: true, maxerr: 50, indent: 4 */
var jsl = typeof jsl === 'undefined' ? {} : jsl;

/**
 * Helper Function for Caret positioning
 * Gratefully borrowed from the Masked Input Plugin by Josh Bush
 * http://digitalbush.com/projects/masked-input-plugin
**/
$.fn.caret = function (begin, end) { 
    if (this.length === 0) {
        return;
    }
    if (typeof begin === 'number') {
        end = (typeof end === 'number') ? end : begin;  
        return this.each(function () {
            if (this.setSelectionRange) {
                this.focus();
                this.setSelectionRange(begin, end);
            } else if (this.createTextRange) {
                var range = this.createTextRange();
                range.collapse(true);
                range.moveEnd('character', end);
                range.moveStart('character', begin);
                range.select();
            }
        });
    } else {
        if (this[0].setSelectionRange) {
            begin = this[0].selectionStart;
            end   = this[0].selectionEnd;
        } else if (document.selection && document.selection.createRange) {
            var range = document.selection.createRange();
            begin = -range.duplicate().moveStart('character', -100000);
            end   = begin + range.text.length;
        }
        return {"begin": begin, "end": end};
    }       
};


/**
 * jsl.interactions - provides support for interactions within JSON Lint.
 *
**/
jsl.interactions = (function () {
    var reformatParam,
        reformat,
        compress;


    /******* UTILITY METHODS *******/

    /**
     * Get the Nth position of a character in a string
     * @searchStr the string to search through
     * @char the character to find
     * @pos int the nth character to find, 1 based.
     *
     * @return int the position of the character found
    **/
    function getNthPos(searchStr, char, pos) {
        var i,
            charCount = 0,
            strArr = searchStr.split(char);

        if (pos === 0) {
            return 0;
        }

        for (i = 0; i < pos; i++) {
            if (i >= strArr.length) {
                return -1;
            }

            // +1 because we split out some characters
            charCount += strArr[i].length + char.length;
        }

        return charCount;
    }

    /**
     * Get a URL parameter from the current windows URL.
     * Courtesy Paul Oppenheim: http://stackoverflow.com/questions/1403888/get-url-parameter-with-jquery
     * @param name the parameter to retrieve
     * @return string the url parameter's value, if any
    **/
    function getURLParameter(name) {
        param = (new RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || ['', null])[1];
        if (param) {
            return decodeURIComponent(param);
        } else {
            return null;
        }
    }

    /******* INTERACTION METHODS *******/

    /**
     * Validate the JSON we've been given, displaying an error or success message.
     * @return void
    **/
    function validate() {
        var lineNum,
            lineMatches,
            lineStart,
            lineEnd,
            jsonVal,
            result;
            
        jsonVal = $('#json_input').val();

        try {
            result = jsl.parser.parse(jsonVal);
            
            if(typeof JSON == 'object'){
                $('#json_input').val(JSON.stringify(JSON.parse(jsonVal), null, "    "))
            }else{
                $('#json_input').val( jsl.format.formatJson(jsonVal) );
            }

            if (result) {
                $('.v-result').text('正确的 JSON')
                    .removeClass("alert-danger")
                    .addClass("alert-success")
                    .show();
            } else {
                alert("An unknown error occurred. Please contact Arc90.");
            }
        } catch (parseException) {

            /** 
             * If we failed to validate, run our manual formatter and then re-validate so that we
             * can get a better line number. On a successful validate, we don't want to run our
             * manual formatter because the automatic one is faster and probably more reliable.
            **/
            try {

                jsonVal = jsl.format.formatJson($('#json_input').val());
                $('#json_input').val(jsonVal);
                result = jsl.parser.parse($('#json_input').val());

            } catch(e) {
                parseException = e;
            }

            lineMatches = parseException.message.match(/line ([0-9]*)/);
            if (lineMatches && typeof lineMatches === "object" && lineMatches.length > 1) {
                lineNum = parseInt(lineMatches[1], 10);

                if (lineNum === 1) {
                    lineStart = 0;
                } else {
                    lineStart = getNthPos(jsonVal, "\n", lineNum - 1);
                }

                lineEnd = jsonVal.indexOf("\n", lineStart);
                if (lineEnd < 0) {
                    lineEnd = jsonVal.length;
                }

                $('#json_input').focus().caret(lineStart, lineEnd);
            }

            // select line
            $(".lineno").eq(lineNum-1).addClass('lineselect');

            $('.v-result').text(parseException.message)
                .removeClass("alert-success")
                .addClass("alert-danger")
                .show();

        }


    }

    function load_joke(){
        var data;

        var update = function(i){
            if(i >= data.length){
                i = 0;
            }

            $(".joke a").attr('href', data[i].url + "?home_right").html(data[i].title);
            setTimeout(function(){
                i++;
                update(i);
            }, 8e3);
        };

        $.getJSON("http://www.kjson.com/h/index.php?callback=?", {
            "m": "content",
            "c": "rss",
            "a": "rnd_title",
            "cid": 10
        }, function(d){
            if(d){
                data = d;
                update(0);
            }
        });
    }

    /**
     * Initialize variables, add event listeners, etc.
     *
     * @return void
    **/
    function init() {
        $('#json_input').linedtextarea();

        $('.variable').click(function () {
            validate();
            return false;
        });

        $(".clear").click(function(){
            $("#json_input").val('');
            $(".v-result").text("")
                .removeClass("alert-danger")
                .removeClass("alert-success");
        });

        //joke
        // load_joke();

    }

    return {
        'init': init
    };
}());

$(function () {
    jsl.interactions.init();
});

