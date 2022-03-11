using DSLParser.Parsers.ConfigurationParser;
using DSLParser.Parsers.LogicParser;

//TODO: Define an API. Maybe this could be a WebAPI a CLI or just a library interface (with the latter we can remove the program.cs).

//Example usage of the parsers
var configurationParser = new ConfigurationParser();
var configurationDSLContent = "";
_ = configurationParser.ParseToModel(configurationDSLContent);

var logicParser = new LogicParser();
var logicDSLContent = "";
_ = logicParser.ParseToModel(logicDSLContent);