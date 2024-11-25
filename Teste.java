public class Teste {
    public static void main(String[] args) {

        try {
            // Testes para ControladorDeErros
            System.out.println("--- Testes para ControladorDeErros ---");

            ControladorDeErros controladorDeErros = new ControladorDeErros(3);
            controladorDeErros.registreUmErro();
            controladorDeErros.registreUmErro();
            controladorDeErros.registreUmErro();

            try {
                controladorDeErros.registreUmErro();
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Esperado: Máximo de erros atingido
            }

            System.out.println("Controlador de erros após registros: " + controladorDeErros.toString()); // Esperado: 3/3


            // classe tracinhos
            System.out.println("--- Testes para Tracinhos ---");

            Tracinhos trac1 = new Tracinhos(5);
            System.out.println("Texto após criação (5 tracinhos): " + trac1.toString()); // Esperado: "_ _ _ _ _"

            //teste método revele
            trac1.revele(2, 'A');
            System.out.println("Texto após revelar a letra 'A' na posição 2: " + trac1.toString()); // Esperado: "_ _ A _ _"

            //teste método isAindaComTracinhos
            System.out.println("Ainda há tracinhos? " + trac1.isAindaComTracinhos()); // Esperado: true

            //teste método clone
            Tracinhos tracClone = (Tracinhos) trac1.clone();
            System.out.println("Clone é igual ao original? " + trac1.equals(tracClone)); // Esperado: true

            //teste método equals
            Tracinhos trac2 = new Tracinhos(5);
            trac2.revele(2, 'A');
            System.out.println("Tracinhos 1 é igual a Tracinhos2? " + trac1.equals(trac2)); // Esperado: true

            //teste método hashCode
            System.out.println("HashCode de trac 1: " + trac1.hashCode()); // Valor numérico (hashcode)

            // Classe Palavra
            System.out.println("--- Testes para Palavra ---");

            //  teste criação da palavra
            Palavra palavra1 = new Palavra("banana");
            Palavra palavra2 = new Palavra("abacaxi");

            // teste método getQuantidade
            System.out.println("Quantidade de 'a' em 'banana': " + palavra1.getQuantidade('a')); // Esperado: 3
            System.out.println("Quantidade de 'b' em 'banana': " + palavra1.getQuantidade('b')); // Esperado: 1

            // teste método getPosicaoDaIezimaOcorrencia
            System.out.println("Posição da 0 ocorrência de 'a' em 'banana': " + palavra1.getPosicaoDaIezimaOcorrencia(0, 'a')); // Esperado: 1
            System.out.println("Posição da 1ª ocorrência de 'a' em 'banana': " + palavra1.getPosicaoDaIezimaOcorrencia(1, 'a')); // Esperado: 3

            // teste método getTamanho
            System.out.println("Tamanho de 'banana': " + palavra1.getTamanho()); // Esperado: 6

            // teste método toString
            System.out.println("toString de palavra 1: " + palavra1.toString()); // Esperado: banana

            // teste método equals
            Palavra palavra3 = new Palavra("banana");
            System.out.println("palavra 1 é igual a palavra 3? " + palavra1.equals(palavra3)); // Esperado: true
            System.out.println("palavra 1 é igual a palavra 2? " + palavra1.equals(palavra2)); // Esperado: false

            // teste o método hashCode
            System.out.println("HashCode de palavra 1: " + palavra1.hashCode()); // Valor numérico (hashcode)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}