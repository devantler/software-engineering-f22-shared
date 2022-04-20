using System.Text.RegularExpressions;
using DSLParser.Metamodel.Base;
using DSLParser.Parsers.Base;
using DSLParser.Tokens;

namespace DSLParser.Parsers.ConfigurationParser;

public class ConfigurationParser : Parser<ConfigurationTokenType>
{
    public override string Name { get; set; } = nameof(ConfigurationParser);
    protected override (ConfigurationTokenType, string)[] TokenStrings { get; set; } = {
        (ConfigurationTokenType.Create, @"(\r\n|\r|\n)"),
        (ConfigurationTokenType.With, @"(\r\n|\r|\n)")
    };
    protected override IEnumerable<(ConfigurationTokenType, Regex)> TokenExpressions { get; set; } = null!;
    protected override List<Token> Tokenize(string source)
    {
        //Run through file and look for tokens.
        //Save top-level tokens as independent tokens
        //Save nested tokens to the nested tokens list for its top-level token.
        //Remember to set all token values.

        //Example logic (not done)
        var foundTokens = new List<Token>();
        var currentLine = 1;
        var currentColumn = 1;

        while (source.Length > 0)
        {
            var matchLength = 0;
            var tokenType = ConfigurationTokenType.None;
            var value = "";

            foreach (var (type, rule) in TokenExpressions)
            {
                var match = rule.Match(source);
                if (match.Success)
                {
                    matchLength = match.Length;
                    tokenType = type;
                    value = match.Value;
                    break;
                }
            }
        }
        return foundTokens;
    }
    protected override IModel Parse(List<Token> tokens)
    {
        throw new NotImplementedException();
    }
}
