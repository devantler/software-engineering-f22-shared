using DSLCompiler.IO;
using DSLCompiler.Metamodel.Base;

namespace DSLCompiler.Parsers.Base;

public interface IParser
{
    IModel Run(FileCollection files);
    IModel Run(FileCollection files, ParserOptions options); //Suggestion: We can make the Optins use lambda.
}
