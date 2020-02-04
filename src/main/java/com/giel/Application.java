package com.giel;

import com.giel.behavioral.chainOfResponsibility.*;
import com.giel.behavioral.command.*;
import com.giel.behavioral.interpreter.AndExpression;
import com.giel.behavioral.interpreter.Expression;
import com.giel.behavioral.interpreter.OrExpression;
import com.giel.behavioral.interpreter.TerminalExpression;
import com.giel.behavioral.iterator.BikeRepository;
import com.giel.behavioral.mediator.Mediator;
import com.giel.behavioral.mediator.TurnOffAllLightsCommand;
import com.giel.behavioral.mediator.TurnOnAllLightsCommand;
import com.giel.behavioral.memento.Caretaker;
import com.giel.behavioral.observer.MessageStream;
import com.giel.behavioral.observer.PhoneClient;
import com.giel.behavioral.observer.Subject;
import com.giel.behavioral.observer.TabletClient;
import com.giel.behavioral.state.Fan;
import com.giel.behavioral.strategy.AmexStrategy;
import com.giel.behavioral.strategy.VisaStrategy;
import com.giel.behavioral.template.OrderTemplate;
import com.giel.behavioral.template.StoreOrder;
import com.giel.behavioral.template.WebOrder;
import com.giel.behavioral.visitor.*;
import com.giel.creational.abstractFactory.CardType;
import com.giel.creational.abstractFactory.CreditCard;
import com.giel.creational.abstractFactory.CreditCardFactory;
import com.giel.creational.builder.LunchOrder;
import com.giel.creational.factory.Website;
import com.giel.creational.factory.WebsiteFactory;
import com.giel.creational.factory.WebsiteType;
import com.giel.creational.prototype.Movie;
import com.giel.creational.prototype.Registry;
import com.giel.creational.singleton.DbSingleton;
import com.giel.structural.adapter.Employee;
import com.giel.structural.adapter.EmployeeClient;
import com.giel.structural.bridge.demo.BridgeDemo;
import com.giel.structural.composite.Menu;
import com.giel.structural.composite.MenuItem;
import com.giel.structural.decorator.DressingDecorator;
import com.giel.structural.decorator.MeatDecorator;
import com.giel.structural.decorator.Sandwich;
import com.giel.structural.decorator.SimpleSandwich;
import com.giel.structural.facade.JdbcFacade;
import com.giel.structural.facade.Address;
import com.giel.structural.flyweight.InventorySystem;
import com.giel.structural.proxy.SecurityProxy;
import com.giel.structural.proxy.TwitterService;
import com.giel.structural.proxy.TwitterServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();

        // dav changes
        // line 1
        // line 2
        // cleanup
        //hotfix
<<<<<<< HEAD
        // line 3
        // line 4
        // line 5
=======
>>>>>>> dev

        // Creational design patterns
//        app.SingletonExample();
//        app.BuilderExample();
//        app.PrototypeExample();
//        app.FactoryExample();
//        app.AbstractFactoryExample();


        // Structural design patterns
//        app.AdapterExample();
//        app.BridgeExample();
//        app.CompositeExample();
//        app.DecoratorExample();
//        app.FacadeExample();
//        app.FlyweightExample();
//        app.ProxyExample();

//        hotfix
        
        // Behavioral design patterns
//        app.ChainOfResponsibilityExample();
//        app.CommandExample();
//        app.InterpreterExample();
//        app.IteratorExample();
//        app.mediatorExample();
//        app.mementoExample();
//        app.observerExample();
//        app.stateExample();
//        app.strategyExample();
//        app.templateExample();

        app.visitorExample();
    }


    // Behavioral design patterns

    private void visitorExample() {
        PartsOrder order = new PartsOrder();
        order.addPart(new Wheel());
        order.addPart(new Fender());
        order.addPart(new Oil());

        order.accept(new AtvPartsShippingVisitor());
        order.accept(new AtvPartsDisplayVisitor());

    }


    private void templateExample() {
        System.out.println("Web Order:");

        OrderTemplate webOrder = new WebOrder();
        webOrder.processOrder();

        System.out.println("\nStore Order:");

        OrderTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();

    }


    private void strategyExample() {
        com.giel.behavioral.strategy.CreditCard amexCard = new com.giel.behavioral.strategy.CreditCard(new AmexStrategy());

        amexCard.setNumber("379185883464283");
        amexCard.setDate("04/2020");
        amexCard.setCvv("123");

        System.out.println("Is Amex valid: " + amexCard.isValid());

        com.giel.behavioral.strategy.CreditCard amexCard2 = new com.giel.behavioral.strategy.CreditCard(new AmexStrategy());

        amexCard2.setNumber("379185883464282");
        amexCard2.setDate("04/2017");
        amexCard2.setCvv("234");

        System.out.println("Is Amex valid: " + amexCard2.isValid());

        com.giel.behavioral.strategy.CreditCard visaCard = new com.giel.behavioral.strategy.CreditCard(new VisaStrategy());

        visaCard.setNumber("4539589763663402");
        visaCard.setDate("05/2018");
        visaCard.setCvv("324");

        System.out.println("Is Visa valid: " + visaCard.isValid());
    }


    private void stateExample() {
        Fan fan = new Fan();

        System.out.println(fan);

        fan.pullChain();

        System.out.println(fan);

        fan.pullChain();

        System.out.println(fan);

        fan.pullChain();

        System.out.println(fan);

        fan.pullChain();

        System.out.println(fan);

    }


    private void observerExample() {
        Subject subject = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(subject);
        TabletClient tabletClient = new TabletClient(subject);

        phoneClient.addMessage("Here is a new message!");
        tabletClient.addMessage("Another new message!");
    }


    private void mementoExample() {

        Caretaker caretaker = new Caretaker();

        com.giel.behavioral.memento.Employee emp = new com.giel.behavioral.memento.Employee();

        emp.setName("John Wick");
        emp.setAddress("111 Main Street");
        emp.setPhone("888-555-1212");

        System.out.println("Employee before save:                     " + emp);

        caretaker.save(emp);

        emp.setPhone("444-555-6666");

        caretaker.save(emp);

        System.out.println("Employee after changed phone number save: " + emp);

        emp.setPhone("333-999-6666"); // <--- we haven't called save!

        caretaker.revert(emp);

        System.out.println("Reverts to last save point:               " + emp);

        caretaker.revert(emp);

        System.out.println("Reverted to original:                     " + emp);
    }


    private void mediatorExample() {
        Mediator mediator = new Mediator();

        com.giel.behavioral.mediator.Light bedroomLight = new com.giel.behavioral.mediator.Light("Bedroom");
        com.giel.behavioral.mediator.Light kitchenLight = new com.giel.behavioral.mediator.Light("kitchen");

        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        com.giel.behavioral.mediator.Command turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
        turnOnAllLightsCommand.execute();

        com.giel.behavioral.mediator.Command turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);
        turnOffAllLightsCommand.execute();
    }


    private void IteratorExample() {
        BikeRepository repo = new BikeRepository();

        repo.addBike("Cervelo");
        repo.addBike("Scott");
        repo.addBike("Fuji");

        Iterator<String> bikeIterator = repo.iterator();

        while(bikeIterator.hasNext()) {
        	System.out.println(bikeIterator.next());
        }

        for (String bike : repo) {
            System.out.println(bike);
        }
    }


    private void InterpreterExample() {

//        String context = "Lions";
        //String context = "Tigers";
        //String context = "Bears";
        String context = "Lions Tigers";
//        String context = "Lions Bears";
//        String context = "Tigers Bears";

        Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
    }
    static Expression buildInterpreterTree() {

        Expression terminal1 = new TerminalExpression("Lions");
        Expression terminal2 = new TerminalExpression("Tigers");
        Expression terminal3 = new TerminalExpression("Bears");

        // Tigers and Bears
        Expression alternation1 = new AndExpression(terminal2, terminal3);
//
//        //Lions or (Tigers and Bears)
        Expression alternation2 = new OrExpression(terminal1, alternation1);
//
        return new AndExpression(terminal3, alternation2);
    }



    private void CommandExample() {
        Light bedroomLight = new Light();
        Light kitchenLight = new Light();
        Switch lightSwitch = new Switch();

        Command toggleCommand = new ToggleCommand(bedroomLight);

        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);

        List<Light> lights = new ArrayList<>();
        lights.add(kitchenLight);
        lights.add(bedroomLight);
        Command allLightsCommand = new AllLightsCommand(lights);

        lightSwitch.storeAndExecute(allLightsCommand);

    }


    private void ChainOfResponsibilityExample() {
        Director bryan = new Director();
        VP crystal = new VP();
        CEO jeff = new CEO();

        bryan.setSuccessor(crystal);
        crystal.setSuccessor(jeff);

        Request request = new Request(RequestType.CONFERENCE, 500);
        bryan.handleRequest(request);

        request = new Request(RequestType.PURCHASE, 1000);
        bryan.handleRequest(request);

        request = new Request(RequestType.PURCHASE, 2000);
        bryan.handleRequest(request);

    }



    // Structural design patterns

    private void ProxyExample() {
        TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());

        System.out.println(service.getTimeline("bh5k"));

        service.postToTimeline("bh5k", "Some message that shouldn't go through.");

    }


    private void FlyweightExample() {
        InventorySystem ims = new InventorySystem();

        ims.takeOrder("Roomba", 221);
        ims.takeOrder("Bose Headphones", 361);
        ims.takeOrder("Samsung TV", 432);
        ims.takeOrder("Samsung TV", 323);
        ims.takeOrder("Roomba", 563);
        ims.takeOrder("Bose Headphones", 321);
        ims.takeOrder("Roomba", 234);
        ims.takeOrder("Samsung TV", 54);
        ims.takeOrder("Roomba", 34);
        ims.takeOrder("Bose Headphones", 365);
        ims.takeOrder("Samsung TV", 332);
        ims.takeOrder("Roomba", 456);

        ims.process();

        System.out.println(ims.report());
    }


    private void FacadeExample() {
        JdbcFacade jdbcFacade = new JdbcFacade();

        jdbcFacade.createTable();

        System.out.println("Table created");

        jdbcFacade.insertIntoTable();

        System.out.println("Record inserted");

        List<Address> addresses = jdbcFacade.getAddress();

        for(Address address: addresses) {
            System.out.println(address.getId() + " " + address.getStreetName() + " " + address.getCity());
        }

    }


    private void DecoratorExample() {
        Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));

        System.out.println(sandwich.make());
    }

    private void CompositeExample() {

        Menu mainMenu = new Menu("Main", "/main");

        MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");

        mainMenu.add(safetyMenuItem);

        Menu claimsSubMenu = new Menu("Claims", "/claims");

        mainMenu.add(claimsSubMenu);

        MenuItem personalClaimsMenu = new MenuItem("Personal Claim", "/personalClaims");

        claimsSubMenu.add(personalClaimsMenu);

        System.out.println(mainMenu.toString());

    }

    private void BridgeExample() {

//        Color blue = new Blue();
////        Shape square = new Square(blue);
////
////        Color red = new Red();
////        Shape circle = new Circle(red);
////
////
////        Color green = new Green();
////        Shape greenCircle = new Circle(green);
////        Shape greenSquare = new Square(green);
////
////        square.applyColor();
////        circle.applyColor();
////        greenCircle.applyColor();
////        greenSquare.applyColor();

        BridgeDemo demo = new BridgeDemo();

        demo.runDemo();

    }

    private void AdapterExample() {

        EmployeeClient client = new EmployeeClient();

        List<Employee> employees = client.getEployeeList();

        System.out.println(employees);

    }




    // Creational design patterns

    private void AbstractFactoryExample() {
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(775);
        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);

        System.out.println(card.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(600);
        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);

        System.out.println(card2.getClass());

    }

    private void FactoryExample() {
        Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);

        System.out.println(site.getPages());

        site = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        System.out.println(site.getPages());

    }

    private void PrototypeExample() {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("Creational Patterns in Java");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of four");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());

    }

    private void BuilderExample() {

        LunchOrder.Builder builder = new LunchOrder.Builder();
        builder.bread("Wheat").condiments("Lettuce").dressing("Mayo").meat("Turkey");
        LunchOrder order = builder.build();

//        LunchOrderTele order = new LunchOrderTele("Wheat", "Lettuce", "Mustard", "Ham");

//        order.setBread("Wheat");
//        order.setCondiments("Lettuce");
//        order.setDressing("Mustard");
//        order.setMeat("Ham");

        System.out.println(order.getBread());
        System.out.println(order.getCondiments());
        System.out.println(order.getDressing());
        System.out.println(order.getMeat());
    }

    private void SingletonExample() {
        DbSingleton instance = DbSingleton.getInstance();

        long timeBefore = 0;
        long timeAfter = 0;

        timeBefore = System.currentTimeMillis();
        Connection conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println(timeAfter - timeBefore);

        Statement statement;
        try {
            statement = conn.createStatement();
            int count = statement.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
            System.out.println("Table created");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        timeBefore = System.currentTimeMillis();
        Connection conn1 = instance.getConnection();
        timeAfter = System.currentTimeMillis();
        System.out.println(timeAfter - timeBefore);
    }

}
