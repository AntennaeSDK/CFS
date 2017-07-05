var fs = require("fs");
var jsonStr = fs.readFileSync("test.json");

// parse the json
var json = JSON.parse(jsonStr);

console.log("header", json.menu.header);