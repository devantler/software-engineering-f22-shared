using DSLParser.Tokens;

namespace DSLParser.Parsers.LogicParser;

public class LogicTokenType : TokenType
{
    public static LogicTokenType If { get; set; } = new(1, nameof(If));
    public LogicTokenType(int id, string name) : base(id, name)
    {
    }
}
