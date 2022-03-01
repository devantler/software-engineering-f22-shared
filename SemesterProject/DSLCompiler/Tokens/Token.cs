namespace DSLCompiler.Tokens;

public abstract class Token
{
    public TokenType Type;
    public string Value = null!;
    public int Line;
}
