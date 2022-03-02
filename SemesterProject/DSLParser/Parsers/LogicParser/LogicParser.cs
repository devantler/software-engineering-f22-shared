using System.Text.RegularExpressions;
using DSLParser.Metamodel.Base;
using DSLParser.Parsers.Base;
using DSLParser.Tokens;

namespace DSLParser.Parsers.LogicParser;

public class LogicParser : Parser<LogicTokenType>
{
    public override string Name { get; set; } = nameof(LogicParser);
    protected override (LogicTokenType, string)[] TokenStrings { get; set; } ={
        (LogicTokenType.If, @"(\r\n|\r|\n)")
    };
    protected override IEnumerable<(LogicTokenType, Regex)> TokenExpressions { get; set; } = null!;

    protected override List<Token> Tokenize(string source)
    {
        throw new NotImplementedException();
    }
    protected override IModel Parse(List<Token> tokens)
    {
        throw new NotImplementedException();
    }
}
