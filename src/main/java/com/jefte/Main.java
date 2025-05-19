package com.jefte;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.jefte.applications.AviaoApplication;
import com.jefte.applications.PassageiroApplication;
import com.jefte.applications.ReservaApplication;
import com.jefte.applications.VooApplication;
import com.jefte.entities.Aviao;
import com.jefte.entities.Passageiro;
import com.jefte.entities.Reserva;
import com.jefte.entities.Voo;
import com.jefte.facade.AviaoFacade;
import com.jefte.facade.PassageiroFacade;
import com.jefte.facade.ReservaFacade;
import com.jefte.facade.VooFacade;
import com.jefte.factores.AviaoFactore;
import com.jefte.factores.PassageiroFactore;
import com.jefte.factores.ReservaFactore;
import com.jefte.factores.VooFactore;
import com.jefte.repositories.AviaoRepository;
import com.jefte.repositories.PassageiroRepository;
import com.jefte.repositories.ReservaRepository;
import com.jefte.repositories.VooRepository;

/**
 * Ola mundo!
 */
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
        Passageiro passageiro1 = new PassageiroFactore("Jefte", "11111111111", "tMw0L@example.com");
        Passageiro passageiro2 = new PassageiroFactore("Jefte2", "11111111111", "tMw0L@example.com");
        Passageiro passageiro3 = new PassageiroFactore("Jefte3", "11111111111", "tMw0L@example.com");
        Passageiro passageiro4 = new PassageiroFactore("Jefte4", "11111111111", "tMw0L@example.com");
        passageiroFacade.append(passageiro1);
        passageiroFacade.append(passageiro2);
        passageiroFacade.append(passageiro3);
        passageiroFacade.append(passageiro4);
    }
    public static void initializeAvioes() {
        Aviao aviao1 = new AviaoFactore("Boeing 737", 180, "Boeing");
        Aviao aviao2 = new AviaoFactore("Airbus A320", 150, "Airbus");
        Aviao aviao3 = new AviaoFactore("Embraer E195", 120, "Embraer");
        Aviao aviao4 = new AviaoFactore("Bombardier CRJ900", 90, "Bombardier");
        aviaoFacade.append(aviao1);
        aviaoFacade.append(aviao2);
        aviaoFacade.append(aviao3);
        aviaoFacade.append(aviao4);
    }

    public static void initializeVoos(){
        Voo voo1 = new VooFactore("São Paulo", "Rio de Janeiro", LocalDateTime.now(), aviaoFacade.getById(0));
        Voo voo2 = new VooFactore("Rio de Janeiro", "Belo Horizonte", LocalDateTime.now(), aviaoFacade.getById(1));
        Voo voo3 = new VooFactore("Belo Horizonte", "Salvador", LocalDateTime.now(), aviaoFacade.getById(2));
        Voo voo4 = new VooFactore("Salvador", "Fortaleza", LocalDateTime.now(), aviaoFacade.getById(3));
        vooFacade.append(voo1);
        vooFacade.append(voo2);
        vooFacade.append(voo3);
        vooFacade.append(voo4);
    }
    public static void initializeReservas() {
        Reserva reserva1 = new ReservaFactore(passageiroFacade.getById(0), vooFacade.getById(0), LocalDateTime.now());
        Reserva reserva2 = new ReservaFactore(passageiroFacade.getById(1), vooFacade.getById(1), LocalDateTime.now());
        Reserva reserva3 = new ReservaFactore(passageiroFacade.getById(2), vooFacade.getById(2), LocalDateTime.now());
        Reserva reserva4 = new ReservaFactore(passageiroFacade.getById(3), vooFacade.getById(3), LocalDateTime.now());
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

        Passageiro passageiro = new PassageiroFactore(nome, cpf, email);
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

        Aviao aviao = new AviaoFactore(modelo, capacidade, fabricante);
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
        Voo voo = new VooFactore(origem, destino, dataHora, aviao);
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
        Reserva reserva = new ReservaFactore(passageiro, voo, dataReserva);
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
