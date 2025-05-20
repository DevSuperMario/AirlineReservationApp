package com;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.applications.AviaoApplication;
import com.applications.PassageiroApplication;
import com.applications.ReservaApplication;
import com.applications.VooApplication;
import com.entities.Aviao;
import com.entities.Passageiro;
import com.entities.Reserva;
import com.entities.Voo;
import com.facade.AviaoFacade;
import com.facade.PassageiroFacade;
import com.facade.ReservaFacade;
import com.facade.VooFacade;
import com.factories.AviaoFactory;
import com.factories.PassageiroFactory;
import com.factories.ReservaFactory;
import com.factories.VooFactory;
import com.repositories.AviaoRepository;
import com.repositories.PassageiroRepository;
import com.repositories.ReservaRepository;
import com.repositories.VooRepository;



public class Main {
    private static AviaoApplication aviaoApplication;
    private static PassageiroApplication passageiroApplication;
    private static ReservaApplication reservaApplication;
    private static VooApplication vooApplication;

    private static VooRepository vooRepository;
    private static PassageiroRepository passageiroRepository;
    private static AviaoRepository aviaoRepository;
    private static ReservaRepository reservaRepository;

    private static VooFacade vooFacade;
    private static AviaoFacade aviaoFacade;
    private static PassageiroFacade passageiroFacade;
    private static ReservaFacade reservaFacade;

    private static Scanner scanner;

    public static void resolveDependencies() {
        vooRepository = new VooRepository();
        vooApplication = new VooApplication(vooRepository, reservaApplication);
        vooFacade = new VooFacade(vooApplication);

        aviaoRepository = new AviaoRepository();
        aviaoApplication = new AviaoApplication(aviaoRepository);
        aviaoFacade = new AviaoFacade(aviaoApplication);

        reservaRepository = new ReservaRepository();
        reservaApplication = new ReservaApplication(reservaRepository);
        reservaFacade = new ReservaFacade(reservaApplication);

        passageiroRepository = new PassageiroRepository();
        passageiroApplication = new PassageiroApplication(passageiroRepository);
        passageiroFacade = new PassageiroFacade(passageiroApplication);

        scanner = new Scanner(System.in);
    }

    public static void initializePassageiros() {
        Passageiro passageiro1 = new PassageiroFactory("Javinha", "11111111111", "tMw0L@example.com");
        Passageiro passageiro2 = new PassageiroFactory("Senaizinho", "11111111111", "tMw0L@example.com");
        Passageiro passageiro3 = new PassageiroFactory("Diabinho", "11111111111", "tMw0L@example.com");
        passageiroFacade.append(passageiro1);
        passageiroFacade.append(passageiro2);
        passageiroFacade.append(passageiro3);
    }
    public static void initializeAvioes() {
        Aviao aviao1 = new AviaoFactory("Boeing 737", 180, "Boeing");
        Aviao aviao2 = new AviaoFactory("Airbus A320", 150, "Airbus");
        Aviao aviao3 = new AviaoFactory("Embraer E195", 120, "Embraer");
        Aviao aviao4 = new AviaoFactory("Bombardier CRJ900", 90, "Bombardier");
        aviaoFacade.append(aviao1);
        aviaoFacade.append(aviao2);
        aviaoFacade.append(aviao3);
        aviaoFacade.append(aviao4);
    }

    public static void initializeVoos(){
        Voo voo1 = new VooFactory("São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviaoFacade.getById(0));
        Voo voo2 = new VooFactory("Rio de Janeiro", "Belo Horizonte", LocalDateTime.now(), aviaoFacade.getById(1));
        Voo voo3 = new VooFactory("Belo Horizonte", "Salvador", LocalDateTime.now(), aviaoFacade.getById(2));
        Voo voo4 = new VooFactory("Salvador", "Fortaleza", LocalDateTime.now(), aviaoFacade.getById(3));
        vooFacade.append(voo1);
        vooFacade.append(voo2);
        vooFacade.append(voo3);
        vooFacade.append(voo4);
    }
    public static void initializeReservas() {
        Reserva reserva1 = new ReservaFactory(passageiroFacade.getById(0), vooFacade.getById(0), LocalDateTime.now());
        Reserva reserva2 = new ReservaFactory(passageiroFacade.getById(1), vooFacade.getById(1), LocalDateTime.now());
        Reserva reserva3 = new ReservaFactory(passageiroFacade.getById(2), vooFacade.getById(2), LocalDateTime.now());
        Reserva reserva4 = new ReservaFactory(passageiroFacade.getById(3), vooFacade.getById(3), LocalDateTime.now());
        reservaFacade.append(reserva1);
        reservaFacade.append(reserva2);
        reservaFacade.append(reserva3);
        reservaFacade.append(reserva4);
    }
    public static void showMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1 - Cadastrar passageiro");
        System.out.println("2 - Listar passageiros");
        System.out.println("3 - Cadastrar avi\u00e3o");
        System.out.println("4 - Listar avi\u00f5es");
        System.out.println("5 - Cadastrar voo");
        System.out.println("6 - Listar voos");
        System.out.println("7 - Reservar passagem");
        System.out.println("8 - Listar reservas");
        System.out.println("9 - Sair");
        System.out.print("Selecione uma op\u00e7\u00e3o: ");
    }


    public static void listarPassageiros() {
        String formatText = "%-10s %-20s %-20s%n";

        // Cabeçalho
        System.out.printf(formatText, "Id", "Nome", "CPF");
        System.out.println("----------------------------------------------------------");

        List<Passageiro> lista = passageiroFacade.getAll();
        if (lista.isEmpty()) {
            System.out.println("Nenhum passageiro cadastrado.");
            return;
        }
        for (Passageiro p : lista) {
            System.out.printf(formatText,
                    p.getId(),
                    p.getNome(),
                    p.getCpf()
            );
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    public static void cadastrarPassageiro() {

        System.out.print("Informe o nome do passageiro: ");
        String nome = scanner.next();

        System.out.print("Informe o CPF do passageiro: ");
        String cpf = scanner.next();

        System.out.print("Informe o e‑mail do passageiro: ");
        String email = scanner.next();

        Passageiro passageiro = new PassageiroFactory(nome, cpf, email);
        passageiroFacade.append(passageiro);

        System.out.println("Passageiro cadastrado com sucesso!");
    }

    public static void listarAvioes() {
        String formatText = "%-10s %-20s %-20s%n";

        System.out.printf(formatText, "Id", "Modelo", "Fabricante");
        System.out.println("----------------------------------------------------------");

        List<Aviao> lista = aviaoFacade.getAll();
        if (lista.isEmpty()) {
            System.out.println("Nenhum avião cadastrado.");
            return;
        }
        for (Aviao a : lista) {
            System.out.printf(formatText,
                    a.getId(),
                    a.getModelo(),
                    a.getFabricante()
            );
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    public static void cadastrarAviao() {
        System.out.print("Informe o modelo do avião: ");
        String modelo = scanner.next();

        System.out.print("Informe a capacidade do avião: ");
        int capacidade = scanner.nextInt();

        System.out.print("Informe o fabricante do avião: ");
        String fabricante = scanner.next();

        Aviao aviao = new AviaoFactory(modelo, capacidade, fabricante);
        aviaoFacade.append(aviao);

        System.out.println("Passageiro cadastrado com sucesso!");
    }

    public static void listarVoos() {
        String formatText = "%-10s %-20s %-20s %-20s %-20s%n";

        System.out.printf(formatText, "Id", "Origem", "Destino", "Data/Hora", "Aviao");
        System.out.println("----------------------------------------------------------");
        List<Voo> lista = vooFacade.getAll();
        if (lista.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }
        for (Voo v : lista) {
            System.out.printf(formatText,
                    v.getId(),
                    v.getOrigem(),
                    v.getDestino(),
                    v.getDataHora().toString().split("T")[0] + " " + v.getDataHora().toString().split("T")[1].substring(0, 5),
                    v.getAviao().getModelo()
            );
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    public static void cadastrarVoo() {

        System.out.print("Informe a origem do voo: ");
        String origem = scanner.next();
        System.out.print("Informe o destino do voo: ");
        String destino = scanner.next();
        System.out.print("Informe a data e hora do voo (yyyy-MM-dd HH:mm): ");
        String dataHoraStr = scanner.next();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr.replace(" ", "T"));
        System.out.print("Informe o id do avião: ");
        int aviaoId = scanner.nextInt();
        Aviao aviao = aviaoFacade.getById(aviaoId);
        if (aviao == null) {
            System.out.println("Avião não encontrado.");
            return;
        }
        Voo voo = new VooFactory(origem, destino, dataHora, aviao);
        vooFacade.append(voo);
        System.out.println("Passageiro cadastrado com sucesso!");
    }

    public static void listarReservas() {
        String formatText = "%-10s %-20s %-20s %-20s %-20s%n";

        System.out.printf(formatText, "Id", "Passageiro", "Voo", "Data/Hora", "Aviao");
        System.out.println("----------------------------------------------------------");
        List<Reserva> lista = reservaFacade.getAll();
        if (lista.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }
        for (Reserva r : lista) {
            System.out.printf(formatText,
                    r.getId(),
                    r.getPassageiro().getNome(),
                    r.getVoo().getOrigem() + " - " + r.getVoo().getDestino(),
                    r.getDataReserva().toString().split("T")[0] + " " + r.getDataReserva().toString().split("T")[1].substring(0, 5),
                    r.getVoo().getAviao().getModelo()
            );
        }
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    public static void reservarPassagem() {

        System.out.print("Informe o id do passageiro: ");
        int passageiroId = scanner.nextInt();
        Passageiro passageiro = passageiroFacade.getById(passageiroId);
        if (passageiro == null) {
            System.out.println("Passageiro não encontrado.");
            return;
        }
        System.out.print("Informe o id do voo: ");
        int vooId = scanner.nextInt();
        Voo voo = vooFacade.getById(vooId);
        if (voo == null) {
            System.out.println("Voo não encontrado.");
            return;
        }
        System.out.print("Informe a data e hora da reserva (yyyy-MM-dd HH:mm): ");
        String dataReservaStr = scanner.next();
        LocalDateTime dataReserva = LocalDateTime.parse(dataReservaStr.replace(" ", "T"));
        Reserva reserva = new ReservaFactory(passageiro, voo, dataReserva);
        reservaFacade.append(reserva);
        System.out.println("Passageiro cadastrado com sucesso!");
    }

    public static void run() {
        int opcao;
        do {
            showMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (opcao) {
                case 1 -> cadastrarPassageiro();
                case 2 -> listarPassageiros();
                case 3 -> cadastrarAviao();
                case 4 -> listarAvioes();
                case 5 -> cadastrarVoo();
                case 6 -> listarVoos();
                case 7 -> reservarPassagem();
                case 8 -> listarReservas();
                case 9 -> System.out.println("Saindo... Até logo!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);
    }

    public static void main(String[] args) {
        resolveDependencies();
        initializePassageiros();

        initializeAvioes();
        initializeVoos();
        initializeReservas();
        run();
    }
}
