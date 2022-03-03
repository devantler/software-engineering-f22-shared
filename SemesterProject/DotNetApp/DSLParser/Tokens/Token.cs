namespace DSLParser.Tokens;

public class Token
{
    public TokenType Type { get; set; } = null!;
    public List<Token> NestedTokens { get; set; } = null!;
    public int Line { get; set; }
    public int Column { get; set; }
    public string Value { get; set; } = null!;
}
