// Classe base para todos os veículos
class Automotor {
    private String modelo; // Modelo do veículo
    private int anoFabricacao; // Ano de fabricação
    private String montadora; // Montadora do veículo
    private String cor; // Cor do veículo
    private double quilometragem; // Quilometragem do veículo

    // Construtor da classe Veiculo
    public Automotor(String modelo, int anoFabricacao, String montadora, String cor, double quilometragem) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.montadora = montadora;
        this.cor = cor;
        this.quilometragem = quilometragem;
    }

    // Método que gera o comando INSERT para o banco de dados
    public String gerarInsert() {
        return "Informações do Veículo - Modelo: " +modelo + ", Ano de Fabricação: " + anoFabricacao +
        		", Montadora: " + montadora + ", Cor: " + cor + ", Quilometragem: " + quilometragem + ".";
    }
}

// Classe que herda de Veiculo para automóveis
class AutomovelDomestico extends Automotor {
    private int quantidadePassageiros; // Quantidade máxima de passageiros
    private String tipoFreio; // Tipo de freio do automóvel
    private boolean airbag; // Se possui airbag

    // Construtor da classe Automovel
    public AutomovelDomestico(String modelo, int anoFabricacao, String montadora, String cor, double quilometragem, 
    		int quantidadePassageiros, String tipoFreio, boolean airbag) {
        super(modelo, anoFabricacao, montadora, cor, quilometragem); // Chama o construtor da superclasse
        this.quantidadePassageiros = quantidadePassageiros;
        this.tipoFreio = tipoFreio;
        this.airbag = airbag;
    }

    public String gerarInsert() {
        return super.gerarInsert() + 
               "\nAutomovelDoméstico - Capacidade max Passageiros: " +quantidadePassageiros + 
               ", Tipo de Freio: " + tipoFreio + ", Possui aribag: " + (airbag ? 1 : 0) + ".\n";
    }
}

// Classe que herda de Veiculo para motocicletas
class Motocicleta extends Automotor {
    private int cilindrada; // Cilindrada da motocicleta
    private double torque; // Torque da motocicleta

    // Construtor da classe Motocicleta
    public Motocicleta(String modelo, int anoFabricacao, String montadora, String cor, double quilometragem,
                       int cilindrada, double torque) {
        super(modelo, anoFabricacao, montadora, cor, quilometragem); // Chama o construtor da superclasse
        this.cilindrada = cilindrada;
        this.torque = torque;
    }
    	
    public String gerarInsert() {
        return super.gerarInsert() +
               "\nMotocicleta - Quantidade de Cilindradas: " + cilindrada + ", Torque: " + torque + ".\n";
    }
}

// Classe que herda de Veiculo para caminhões
class Caminhao extends Automotor {
    private int quantidadeEixos; // Quantidade de eixos do caminhão
    private double pesoBruto; // Peso bruto do caminhão

    // Construtor da classe Caminhao
    public Caminhao(String modelo, int anoFabricacao, String montadora, String cor, double quilometragem,
                    int quantidadeEixos, double pesoBruto) {
        super(modelo, anoFabricacao, montadora, cor, quilometragem); // Chama o construtor da superclasse
        this.quantidadeEixos = quantidadeEixos;
        this.pesoBruto = pesoBruto;
    }

    public String gerarInsert() {
        return super.gerarInsert() +
               "\nCaminhao - Quantidade de Eixos: "+ quantidadeEixos + ", Peso Bruto: " + pesoBruto + ".\n";
    }
}

// nova super Classe para os 2 ultimos itens
class VeiculoRadical{
	private String modelo;
	private String marca;
	private String cor;
	private int anoFabricacao;
	
	public VeiculoRadical(String modelo,String marca,String cor,int anoFabricacao) {
	this.modelo = modelo;
	this.marca = marca;
	this.cor = cor;
	this.anoFabricacao = anoFabricacao;
	}

		// Instancio mais um INSERT apenas para essa super Classe
		public String InsertRadical() {
	        return "Informações do Veículo - Modelo: " + modelo + ", Marca: " + marca + ", Cor: " + cor +
	        		", Ano de Fabricação: " + anoFabricacao + ".";
	    }
}

// Classe para bicicletas saindo de VeiculoRadical
class Bicicleta extends VeiculoRadical{
    private String material; // Material da bicicleta
    private int quantidadeMarchas; // Quantidade de marchas da bicicleta
    private boolean amortecedor; // Se possui amortecedor

    // Construtor da classe Bicicleta
    public Bicicleta(String modelo, String marca, String cor, int anoFabricacao, String material, int quantidadeMarchas, boolean amortecedor) {
    	super(modelo, marca, cor, anoFabricacao);
        this.material = material;
        this.quantidadeMarchas = quantidadeMarchas;
        this.amortecedor = amortecedor;
    }

	// Utilizando o INSERT que foi criado
    public String InsertRadical() {
        return super.InsertRadical()+ 
        		"\nBicicleta - Material: " + material + ", Quantidade de Marchas: " + quantidadeMarchas + ", Possui Amortecedor: " +
                (amortecedor ? 1 : 0)+".\n";
    }
}

// Classe para skates saindo de VeiculoRadical
class Skate extends VeiculoRadical{
    private String tipoRodas; // Tipo das rodas do skate

    // Construtor da classe Skate
    public Skate(String modelo, String marca, String cor, int anoFabricacao, String tipoRodas) {
        super(modelo, marca, cor, anoFabricacao);
        this.tipoRodas = tipoRodas;
    }

	// Utilizando o INSERT que foi criado
    public String InsertRadical() {
        return super.InsertRadical()+
        		"\nSkate - Tipo de Rodas: " + tipoRodas + ".";
    }
}

// Classe Principal onde vamos testar todas as classes
public class Main{
    public static void main(String[] args) {
        // Criação de um automóvel doméstico
        AutomovelDomestico carro = new AutomovelDomestico("Fusca", 1975, "Volkswagen", "azul", 100000, 4, "ABS", true);
        System.out.println(carro.gerarInsert());

        // Criação de uma motocicleta
        Motocicleta moto = new Motocicleta("CB500", 2020, "Honda", "vermelha", 5000, 500, 45);
        System.out.println(moto.gerarInsert());

        // Criação de um caminhão
        Caminhao caminhão = new Caminhao("Scania", 2018, "Scania", "branco", 200000, 6, 30000);
        System.out.println(caminhão.gerarInsert());

        // Criação de uma bicicleta
        Bicicleta bicicleta = new Bicicleta("Mountain Bike", "Caloi", "preta", 2021, "alumínio", 3, true);
        System.out.println(bicicleta.InsertRadical());

        // Criação de um skate
        Skate skate = new Skate("Skate Profissional", "Pineapple", "azul", 2012, "PVC");
        System.out.println(skate.InsertRadical());
    }
}

