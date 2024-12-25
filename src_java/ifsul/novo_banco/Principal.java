package ifsul.novo_banco;

public class Principal {
    private static void main(String[] args) {
        Imovel imovel = new Imovel();
        imovel.setConstrutora("Doce Lar");
        imovel.setEndereço("rua da Felicidade, 666, Porto Alegre, RS");
        imovel.setNroDonos(0);
        imovel.setTamanho(100);
        imovel.setValor(200000);

        System.out.println("Contrutora: " + imovel.getConstrutora());
        System.out.println("Imovel: " + imovel.getEndereço());
        System.out.println("Numeor de donos: " + imovel.getNroDonos());
        System.out.printf("Tamanho: %sm²\n", imovel.getTamanho());
        System.out.println("Valor: R$" + imovel.getValor());
    }
}
