
var JavaConsole = Java.type('org.github.antennae.cfs.javscript.JavaConsole');

var Console = {
    log : function(msg){
        JavaConsole.log( "JavaConsole:   " + msg);
    }
};

var console = Object.create(Console);


function getHeader( jsonStr ){

    var json = JSON.parse(jsonStr);
    var header = json.menu.header;

    console.log("Header = "+ header);
    return header;
}

function getItems( jsonStr ){

    var json = JSON.parse(jsonStr);
    var items = json.menu.items;

    console.log("Items: "+ items);
    return items
}
