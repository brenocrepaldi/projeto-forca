public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // torna this.letrasJaDigitadas igual ao String vazio
        letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo
        for(int i = 0; i < letrasJaDigitadas.length(); i++){
            if(letrasJaDigitadas.charAt(i) == letra)
                return true;
        }
        return false;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o m�todo this.isJaDigitada, para isso), lancando uma exce��o
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.
        if(this.isJaDigitada(letra)) throw new Exception("Letra já digitada");
        letrasJaDigitadas += letra;
    }

    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por v�rgula (,).
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < letrasJaDigitadas.length(); i++){
            s.append(letrasJaDigitadas.charAt(i));
        }
        return s.toString();
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj s�o iguais
        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        ControladorDeLetrasJaDigitadas c = (ControladorDeLetrasJaDigitadas) obj;
        if(c.letrasJaDigitadas.equals(this.letrasJaDigitadas)) return true;
        return false;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 1;
        ret = ret*13 + this.letrasJaDigitadas.hashCode();
        if(ret < 0)ret = -ret;
        return ret;
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de c�pia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
        if (controladorDeLetrasJaDigitadas == null)
            throw new Exception("Instância inválida");
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone ()
    {
        // criar uma c�pia do this com o construtor de c�pia e retornar
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = null;
        try {
            controladorDeLetrasJaDigitadas =  new ControladorDeLetrasJaDigitadas(this);
        } catch (Exception e) {
            return null; // Retorna null em caso de falha no clone
        }

        return controladorDeLetrasJaDigitadas;
    }
}
