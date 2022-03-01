using DSLCompiler.IO;
using DSLCompiler.Metamodel.Base;

namespace DSLCompiler.Parsers.Base
{
    public abstract class Parser : IParser
    {
        public string Name { get; set; } = null!;

        public IModel Run(FileCollection files)
        {
            // I used some more practical names instead of Lex Parse and NameResolute.
            var tokens = Tokenize(files); // The Lexing step
            var model = Parse(tokens); // The Parsing step
            return Finalize(model); // The Name Resolution step (not super necessary)
        }
        public IModel Run(FileCollection files, ParserOptions options)
        {
            throw new NotImplementedException();
        }
        protected abstract Dictionary<Guid, Token> Tokenize(FileCollection files);
        protected abstract IModel Parse(Dictionary<Guid, Token> tokens);
        protected abstract IModel Finalize(IModel model);
    }
}