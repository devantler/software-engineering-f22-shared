using DSLCompiler.IO;
using DSLCompiler.Parsers.ConfigurationParser;
using DSLCompiler.Parsers.LogicParser;

//TODO: Define an API. Maybe this could be a WebAPI a CLI or just a library interface (with the latter we can remove the program.cs).

//Example usage of the parsers
var configurationParser = new ConfigurationParser();
var fileInfo = new FileInfo("configuration.conf"); // where configuration.conf is our configurations DSL file.
var files = new FileCollection();
files = (FileCollection)files.Append(fileInfo);
configurationParser.Run(files);

var logicParser = new LogicParser();
fileInfo = new FileInfo("logic.lgc"); // where logic.lgc is our logic DSL file.
files = new FileCollection();
files = (FileCollection)files.Append(fileInfo);
logicParser.Run(files);