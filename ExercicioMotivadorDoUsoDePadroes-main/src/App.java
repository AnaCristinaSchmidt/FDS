import javax.swing.text.Utilities;

public class App {
    public static void main(String[] args) throws Exception {

        //Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);

        // System.out.println("Tipos de veiculos:");
        // System.out.println(basico);

        // System.out.println("\n\n----------------");
        // System.out.println("\nAbastencendo carro basico com gasolina");
        // basico.abastece(TipoCombustivel.GASOLINA, 55);
        // System.out.println(basico);
        // System.out.println("\nViajando com o carro basico");
        // basico.viaja(250);
        // basico.viaja(150);
        // System.out.println(basico);


    //    Carro esportivo =  new Carro("esportivo", TipoCombustivel.GASOLINA, 6, 45);
    //     System.out.println("Tipos de veiculos:");
    //     System.out.println(basico);
    //     System.out.println(esportivo);

    //     System.out.println("\n\n----------------");
    //     System.out.println("\nAbastencendo carro esportivo com gasolina");
    //     esportivo.abastece(TipoCombustivel.GASOLINA, 45);
    //     System.out.println(esportivo);
    //     System.out.println("\nViajando com o carro esportivo");
    //     esportivo.viaja(250);
    //     esportivo.viaja(150);
    //     System.out.println(esportivo);

        // Carro utilitario =  new Carro("utilitario", TipoCombustivel.DIESEL, 5, 70);
        // System.out.println("Tipos de veiculos:");
        // System.out.println(basico);
        // System.out.println(utilitario);

        // System.out.println("\n\n----------------");
        // System.out.println("\nAbastencendo carro utilitario com gasolina");
        // utilitario.abastece(TipoCombustivel.DIESEL, 70);
        // System.out.println(utilitario);
        // System.out.println("\nViajando com o carro utilitario");
        // utilitario.viaja(250);
        // utilitario.viaja(150);
        // System.out.println(utilitario);

        Carro suv = new Carro("SUV", TipoCombustivel.FLEX, TipoCombustivel.GASOLINA, 8, 55);
        System.out.println("Tipos de veiculos:");
        // System.out.println(basico);
        System.out.println(suv);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro SUV com gasolina");
        suv.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(suv);
        System.out.println("\nViajando com o carro SUV");
        suv.viaja(250);
        suv.viaja(150);
        System.out.println(suv);

         Carro suvFlex = new Carro("SUV", TipoCombustivel.FLEX, TipoCombustivel.FLEX, 8, 55);



    }

}
