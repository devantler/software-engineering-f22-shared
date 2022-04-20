using System.Text.RegularExpressions;
using DSLParser.Metamodel.Base;
using DSLParser.Tokens;

namespace DSLParser.Parsers.Base
{
    public abstract class Parser<TTokenType> : IParser
    {
        public abstract string Name { get; set; }
        protected abstract (TTokenType, string)[] TokenStrings { get; set; }
        protected abstract IEnumerable<(TTokenType, Regex)> TokenExpressions { get; set; }
        protected Parser()
        {
            TokenExpressions = TokenStrings.Select(t => (t.Item1, new Regex($"^{t.Item2}", RegexOptions.Compiled | RegexOptions.Singleline)));
        }
        public IModel ParseToModel(string source)
        {
            var tokens = Tokenize(source); // The Lexing step
            return Parse(tokens); // The Parsing step
        }
        public IModel ParseToModel(string source, ParserOptions options)
        {
            return ParseToModel(source);
        }
        protected abstract List<Token> Tokenize(string content);
        protected abstract IModel Parse(List<Token> tokens);
    }
}