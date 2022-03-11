using System.Text.RegularExpressions;
using DSLParser.Metamodel.Base;

namespace DSLParser.Parsers.Base;

public interface IParser
{
    string Name { get; set; }
    IModel ParseToModel(string source);
    IModel ParseToModel(string content, ParserOptions options); //Suggestion: We can make the Optins use lambda.
}
