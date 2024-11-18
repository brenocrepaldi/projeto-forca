public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// verifica se o texto recebido � nulo ou ent�o vazio,
		// ou seja, sem nenhum caractere, lan�ando exce��o.
		// armazena o texto recebido em this.texto.
        if(texto == null || texto.trim().isEmpty()) throw new Exception("Texto inválido");
        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
        int count = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            if (this.texto.charAt(i) == letra) {
                count++;
            }
        }
        return count;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lan�ar excecao caso nao encontre em this.texto
        // a I�zima apari��o da letra fornecida.

        int count = 0;
        for (int pos = 0; pos < this.texto.length(); pos++) {
            if (this.texto.charAt(pos) == letra) {
                if (count == i) {
                    return pos;
                }
                count++;
            }
        }

        throw new Exception("Letra não encontrada");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo

        if(obj == this) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Palavra palavra = (Palavra)obj;
        if(this.texto.equals(palavra.texto)) return true;
        return false;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 1;
        ret = 2 * ret + this.texto.hashCode();
        return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
