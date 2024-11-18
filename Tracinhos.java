public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
		// verifica se qtd n�o � positiva, lan�ando uma exce��o.
		// instancia this.texto com um vetor com tamanho igual qtd.
		// preenche this.texto com underlines (_).

        if(qtd < 0) throw new Exception("Quantidade menor que zero");
        texto  = new char[qtd];
        for (int i = 0; i < qtd; i++)
            this.texto[i] = '_';
    }

    public void revele (int posicao, char letra) throws Exception
    {
		// verifica se posicao � negativa ou ent�o igual ou maior
		// do que this.texto.length, lan�ando uma exce��o.
		// armazena a letra fornecida na posicao tambem fornecida
		// do vetor this.texto
        if(posicao >= this.texto.length || posicao < 0)
            throw new Exception("Posição inválida");
        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        // percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; retornar true
        // caso ainda reste algum underline, ou false caso
        // contrario
        for (char c : this.texto) {
            if (c == '_') {
                return true;
            }
        }
        return false;
    }

        public String toString ()
        {
            // retorna um String com TODOS os caracteres que h�
            // no vetor this.texto, intercalados com espa�os em
            // branco
            StringBuilder s = new StringBuilder();
            for (char c : this.texto) {
                s.append(c).append(" ");
            }

            return s.toString().trim();
        }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        Tracinhos o = (Tracinhos)obj;
        if (this.texto.length != o.texto.length) return false;
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] != o.texto[i]) return false;
        }
        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 1;
        for (char c : this.texto) {
            ret *= 2 * c;
        }
        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        // intanciar this.texto um vetor com o mesmo tamanho de t.texto
        // e copilar o conte�do de t.texto para this.texto
        if (t == null)
            throw new Exception("Instância inválida");

        this.texto = new char[t.texto.length];
        for (int i = 0; i < t.texto.length; i++) {
            this.texto[i] = t.texto[i];
        }
    }

    public Object clone ()
    {
        // retornar uma copia de this
        Tracinhos t = null;
        try {
            t = new Tracinhos(this);
        } catch (Exception e) {}

        return t;
    }
}
