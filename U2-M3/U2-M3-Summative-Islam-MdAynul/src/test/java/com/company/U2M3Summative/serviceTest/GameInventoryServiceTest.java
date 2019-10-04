package com.company.U2M3Summative.serviceTest;

import com.company.U2M3Summative.dao.*;
import com.company.U2M3Summative.model.*;
import com.company.U2M3Summative.service.GameInventoryService;
import com.company.U2M3Summative.viewModel.ConsoleViewModel;
import com.company.U2M3Summative.viewModel.GameViewModel;
import com.company.U2M3Summative.viewModel.InvoiceViewModel;
import com.company.U2M3Summative.viewModel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class GameInventoryServiceTest {


    GameDao gameDao;
    TShirtsDao tShirtsDao;
    ConsoleDao consoleDao;
    InvoiceDao invoiceDao;
    SalesTaxRateDao salesTaxRateDao;
    ProcessingFeeDao processingFeeDao;

    //service layer
    GameInventoryService service;


    @Before
    public void setUp() throws Exception{

        setUpGameDaoMock();
        setUpTShirtDaoMock();
        setUpConsoleDaoMock();
        setUpInvoiceDaoMock();
        setUpSalesTaxRateDaoMock();
        setUpProcessingFeeDaoMock();

        service = new GameInventoryService(gameDao, consoleDao, tShirtsDao,
                        invoiceDao,processingFeeDao,salesTaxRateDao);

    }
    /*******************************GameMockTest ******************************/

    @Test
    public void saveGame(){

        GameViewModel gameViewModel = new GameViewModel();

        //adding the first game from the save game
        //from GameDao Mock without the id
        gameViewModel.setTitle("Resident Evil");
        gameViewModel.setEsrbRating("M1");
        gameViewModel.setDescription("Action");
        gameViewModel.setPrice(new BigDecimal("19.99"));
        gameViewModel.setStudio("Press");
        gameViewModel.setQuantity(5);

        gameViewModel=service.saveGame(gameViewModel); // saving to the service and put it again in the gameViewModel

        GameViewModel fromService= service.findGame(gameViewModel.getGameId());
        assertEquals(gameViewModel,fromService);
    }

    @Test
    public void findGame(){

        //taking the first game from saveGame GameDaoMock
        Game game = new Game();

        game.setGameId(1);
        game.setTitle("Resident Evil");
        game.setEsrbRating("M1");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Press");
        game.setQuantity(5);

        //adding the game into the GameViewModel
        GameViewModel gameViewModel = service.findGame(1);

        //Create another game object and passing gameViewModel to compare

        Game game1 = new Game();

        game1.setGameId(gameViewModel.getGameId());
        game1.setTitle(gameViewModel.getTitle());
        game1.setEsrbRating(gameViewModel.getEsrbRating());
        game1.setDescription(gameViewModel.getDescription());
        game1.setPrice(gameViewModel.getPrice());
        game1.setStudio(gameViewModel.getStudio());
        game1.setQuantity(gameViewModel.getQuantity());

        assertEquals(game1,game);
    }

    @Test
    public void findAllGames(){

        //getting all the games from GameViewModel
        List<GameViewModel> fromService=service.findAllGames();

        assertEquals(1,fromService.size());
    }

    @Test
    public void updateGame(){

        GameViewModel gameViewUpdate = new GameViewModel();

        //creating a game to update
        //taking the game from the update chunk from gameDao
        Game updateGame = new Game();

        updateGame.setGameId(2);
        updateGame.setTitle("Resident Updated");
        updateGame.setEsrbRating("M1 Updated");
        updateGame.setDescription("Action Updated");
        updateGame.setPrice(new BigDecimal("19.99"));
        updateGame.setStudio("Press");
        updateGame.setQuantity(5);

        //passing the game into gameViewUpdate
        gameViewUpdate.setGameId(updateGame.getGameId());
        gameViewUpdate.setTitle(updateGame.getTitle());
        gameViewUpdate.setEsrbRating(updateGame.getEsrbRating());
        gameViewUpdate.setDescription(updateGame.getDescription());
        gameViewUpdate.setPrice(updateGame.getPrice());
        gameViewUpdate.setStudio(updateGame.getStudio());
        gameViewUpdate.setQuantity(updateGame.getQuantity());

        service.updateGame(gameViewUpdate);

        //find the game we just updated
        GameViewModel gameViewModel= service.findGame(2);

        //passing the updated game into game after update
        Game gameAfterUpdate= new Game();

        gameAfterUpdate.setGameId(gameViewModel.getGameId());
        gameAfterUpdate.setTitle(gameViewModel.getTitle());
        gameAfterUpdate.setEsrbRating(gameViewModel.getEsrbRating());
        gameAfterUpdate.setDescription(gameViewModel.getDescription());
        gameAfterUpdate.setPrice(gameViewModel.getPrice());
        gameAfterUpdate.setStudio(gameViewModel.getStudio());
        gameAfterUpdate.setQuantity(gameViewModel.getQuantity());

        //comparing both game

        assertEquals(gameAfterUpdate,updateGame);

    }

    @Test
    public void removeGame(){
        //taking the id from remove game which is 3
        service.removeGame(3);

        GameViewModel gameViewModel = service.findGame(3); //finding the deleted game
        assertNull(gameViewModel);
    }

    @Test
    public void  getGamesByStudio(){


        GameViewModel gameViewModel = new GameViewModel();

        //adding the first game from the save game
        //from GameDao Mock without the id
        gameViewModel.setTitle("Resident Evil");
        gameViewModel.setEsrbRating("M1");
        gameViewModel.setDescription("Action");
        gameViewModel.setPrice(new BigDecimal("19.99"));
        gameViewModel.setStudio("Press");
        gameViewModel.setQuantity(5);

        gameViewModel=service.saveGame(gameViewModel); // saving to the service and put it again in the gameViewModel

        List<GameViewModel> byStudio= service.findGamesByStudio("Press");

        assertEquals(1,byStudio.size());

        byStudio=service.findGamesByStudio("Fake studio");
        assertEquals(0,byStudio.size());

    }

    @Test
    public void getGamesByESRBRatings(){

        GameViewModel gameViewModel = new GameViewModel();

        //adding the first game from the save game
        //from GameDao Mock without the id
        gameViewModel.setTitle("Resident Evil");
        gameViewModel.setEsrbRating("M1");
        gameViewModel.setDescription("Action");
        gameViewModel.setPrice(new BigDecimal("19.99"));
        gameViewModel.setStudio("Press");
        gameViewModel.setQuantity(5);

        gameViewModel=service.saveGame(gameViewModel); // saving to the service and put it again in the gameViewModel

        List<GameViewModel> byESRBRatings= service.findGamesByESRBRatings("M1");

        assertEquals(1,byESRBRatings.size());

        byESRBRatings=service.findGamesByStudio("Fake Ratings");
        assertEquals(0,byESRBRatings.size());
    }

    @Test
    public void getGamesByTitle(){

        GameViewModel gameViewModel = new GameViewModel();

        //adding the first game from the save game
        //from GameDao Mock without the id
        gameViewModel.setTitle("Resident Evil");
        gameViewModel.setEsrbRating("M1");
        gameViewModel.setDescription("Action");
        gameViewModel.setPrice(new BigDecimal("19.99"));
        gameViewModel.setStudio("Press");
        gameViewModel.setQuantity(5);

        gameViewModel=service.saveGame(gameViewModel); // saving to the service and put it again in the gameViewModel

        List<GameViewModel> byTitle= service.findGamesByTitle("Resident Evil");

        assertEquals(1,byTitle.size());

        byTitle=service.findGamesByStudio("Fake Ratings");
        assertEquals(0,byTitle.size());
    }

    /******************************* End of GameDaoMockTest  ******************************/

    @Test
    public void saveTShirt(){

        TShirtViewModel tShirtViewModel =new TShirtViewModel();

        //adding the first TShirt from the save TShirt
        //from TShirtDaoMock without the Id

        tShirtViewModel.setSize("M");
        tShirtViewModel.setColor("Black");
        tShirtViewModel.setDescription("V-Neck");
        tShirtViewModel.setPrice(new BigDecimal("19.99"));
        tShirtViewModel.setQuantity(5);

        tShirtViewModel = service.saveTShirt(tShirtViewModel); //saving to the service and put it again on tShirtViewModel

        TShirtViewModel fromService= service.findTShirt(tShirtViewModel.gettShirtId());
        assertEquals(tShirtViewModel,fromService);

    }

    @Test
    public void findTShirt(){

        //taking the first TShirt from add TShirt from TShirtDao

        TShirt tShirt = new TShirt();

        tShirt.settShirtId(1);
        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(5);

        //adding the TShirt to the TShirtViewModel

        TShirtViewModel tShirtViewModel = service.findTShirt(1);

        //create another TShirt object and passing the tShirtViewModel to compare

        TShirt tShirt1 = new TShirt();

        tShirt1.settShirtId(tShirtViewModel.gettShirtId());
        tShirt1.setSize(tShirtViewModel.getSize());
        tShirt1.setColor(tShirtViewModel.getColor());
        tShirt1.setDescription(tShirtViewModel.getDescription());
        tShirt1.setPrice(tShirtViewModel.getPrice());
        tShirt1.setQuantity(tShirtViewModel.getQuantity());

        assertEquals(tShirt1,tShirt);

    }
    @Test
    public void findAllTShirts(){

        //getting all the TShirt from TShirtViewModel

        List<TShirtViewModel> fromService= service.findAllTShirts();

        assertEquals(1,fromService.size());
    }

    @Test
    public void updateTShirt(){

        TShirtViewModel tShirtViewUpdate = new TShirtViewModel();

        //Creating a TShirt to update
        //taking the same TShirt from Update chunk from TShirtDao

        TShirt updateTShirt= new TShirt();

        updateTShirt.settShirtId(2);
        updateTShirt.setSize("M Updated");
        updateTShirt.setColor("Black Updated");
        updateTShirt.setDescription("V-Neck Updated");
        updateTShirt.setPrice(new BigDecimal("19.99"));
        updateTShirt.setQuantity(5);

        //passing the TShirt into tShirtViewUpdate

        tShirtViewUpdate.settShirtId(updateTShirt.gettShirtId());
        tShirtViewUpdate.setSize(updateTShirt.getSize());
        tShirtViewUpdate.setColor(updateTShirt.getColor());
        tShirtViewUpdate.setDescription(updateTShirt.getDescription());
        tShirtViewUpdate.setPrice(updateTShirt.getPrice());
        tShirtViewUpdate.setQuantity(updateTShirt.getQuantity());

        service.updateTShirt(tShirtViewUpdate);

        //finding the TShirt we just updated
        TShirtViewModel tShirtViewModel=service.findTShirt(2);

        TShirt tShirtAfterUpdate= new TShirt();

        tShirtAfterUpdate.settShirtId(tShirtViewModel.gettShirtId());
        tShirtAfterUpdate.setSize(tShirtViewModel.getSize());
        tShirtAfterUpdate.setColor(tShirtViewModel.getColor());
        tShirtAfterUpdate.setDescription(tShirtViewModel.getDescription());
        tShirtAfterUpdate.setPrice(tShirtViewModel.getPrice());
        tShirtAfterUpdate.setQuantity(tShirtViewModel.getQuantity());

        //comparing both TShirt
        assertEquals(tShirtAfterUpdate,updateTShirt);

    }

    @Test
    public void removeTShirt(){

        //taking the id from remove chunk from TShirtDaoMock
        service.removeTShirt(3);

        TShirtViewModel tShirtViewModel = service.findTShirt(3); // trying to find the deleted TShirt
        assertNull(tShirtViewModel);
    }

    @Test
    public void getTShirtsByColor(){

    TShirtViewModel tShirtViewModel = new TShirtViewModel();

    //adding the first TShirt from the save T Shirt
    // from the TShirtDao Mock without the id

        tShirtViewModel.setSize("M");
        tShirtViewModel.setColor("Black");
        tShirtViewModel.setDescription("V-Neck");
        tShirtViewModel.setPrice(new BigDecimal("19.99"));
        tShirtViewModel.setQuantity(5);

        tShirtViewModel = service.saveTShirt(tShirtViewModel); // adding into service

        List<TShirtViewModel> byColor = service.findTShirtsByColor("Black");
        assertEquals(1,byColor.size());

        byColor = service.findTShirtsByColor("Fake Color");
        assertEquals(0,byColor.size());

    }

    @Test
    public void getTShirtsBySize(){

        TShirtViewModel tShirtViewModel = new TShirtViewModel();

        //adding the first TShirt from the save T Shirt
        // from the TShirtDao Mock without the id

        tShirtViewModel.setSize("M");
        tShirtViewModel.setColor("Black");
        tShirtViewModel.setDescription("V-Neck");
        tShirtViewModel.setPrice(new BigDecimal("19.99"));
        tShirtViewModel.setQuantity(5);

        tShirtViewModel = service.saveTShirt(tShirtViewModel); // adding into service

        List<TShirtViewModel> bySize = service.findTShirtsBySize("M");
        assertEquals(1,bySize.size());

        bySize = service.findTShirtsByColor("Fake Size");
        assertEquals(0,bySize.size());

    }

    /******************************* End of TShirtDaoMockTest  ******************************/

    @Test
    public void saveConsole(){

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        //adding the first console from the add Console
        // from the ConsoleDaoMock without the id

        consoleViewModel.setModel("Matrix");
        consoleViewModel.setManufacturer("Matrix Man");
        consoleViewModel.setMemoryAmount("500MB");
        consoleViewModel.setProcessor("G7");
        consoleViewModel.setPrice(new BigDecimal("29.99"));
        consoleViewModel.setQuantity(5);

        consoleViewModel = service.saveConsole(consoleViewModel); //saving to the service and put it again in consoleViewModel

        ConsoleViewModel fromService= service.findConsole(consoleViewModel.getConsoleId());

        assertEquals(consoleViewModel,fromService);
    }

    @Test
    public void findConsole(){

        //taking the Console from the add console from consoleDaoMock

        Console console = new Console();

        console.setConsoleId(1);
        console.setModel("Matrix");
        console.setManufacturer("Matrix Man");
        console.setMemoryAmount("500MB");
        console.setProcessor("G7");
        console.setPrice(new BigDecimal("29.99"));
        console.setQuantity(5);

        //adding the console to the ConsoleViewModel

        ConsoleViewModel consoleViewModel = service.findConsole(1);

        //creating another Console object and passing the consoleViewModel to compare

        Console console1 = new Console();

        console1.setConsoleId(consoleViewModel.getConsoleId());
        console1.setModel(consoleViewModel.getModel());
        console1.setManufacturer(consoleViewModel.getManufacturer());
        console1.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console1.setProcessor(consoleViewModel.getProcessor());
        console1.setPrice(consoleViewModel.getPrice());
        console1.setQuantity(consoleViewModel.getQuantity());

        assertEquals(console1,console);

    }

    @Test
    public void findAllConsoles(){
        //getting all the consoles from consoleViewModel

        List<ConsoleViewModel> fromService = service.findAllConsoles();

        assertEquals(1,fromService.size());
    }

    @Test
    public void updateConsole(){

        ConsoleViewModel consoleViewUpdate = new ConsoleViewModel();

        //Creating a Console to update
        // Taking the same console from the Update chunk from ConsoleDao

        Console updateConsole= new Console();

        updateConsole.setConsoleId(2);
        updateConsole.setModel("Matrix Updated");
        updateConsole.setManufacturer("Matrix Man Updated");
        updateConsole.setMemoryAmount("500MB");
        updateConsole.setProcessor("G7");
        updateConsole.setPrice(new BigDecimal("29.99"));
        updateConsole.setQuantity(5);

        //passing the console into the consoleViewModel

        consoleViewUpdate.setConsoleId(updateConsole.getConsoleId());
        consoleViewUpdate.setModel(updateConsole.getModel());
        consoleViewUpdate.setManufacturer(updateConsole.getManufacturer());
        consoleViewUpdate.setMemoryAmount(updateConsole.getMemoryAmount());
        consoleViewUpdate.setProcessor(updateConsole.getProcessor());
        consoleViewUpdate.setPrice(updateConsole.getPrice());
        consoleViewUpdate.setQuantity(updateConsole.getQuantity());

        service.updateConsole(consoleViewUpdate);

        //finding the console we just updated

        ConsoleViewModel consoleViewModel= service.findConsole(consoleViewUpdate.getConsoleId());

        Console consoleAfterUpdate= new Console();

        consoleAfterUpdate.setConsoleId(consoleViewModel.getConsoleId());
        consoleAfterUpdate.setModel(consoleViewModel.getModel());
        consoleAfterUpdate.setManufacturer(consoleViewModel.getManufacturer());
        consoleAfterUpdate.setMemoryAmount(consoleViewModel.getMemoryAmount());
        consoleAfterUpdate.setProcessor(consoleViewModel.getProcessor());
        consoleAfterUpdate.setPrice(consoleViewModel.getPrice());
        consoleAfterUpdate.setQuantity(consoleViewModel.getQuantity());

        //comparing both Console

        assertEquals(consoleAfterUpdate,updateConsole);

    }

    @Test
    public void removeConsole(){

        //taking the id from remove chunk from ConsoleDaoMock
        service.removeConsole(3);

        ConsoleViewModel consoleViewModel = service.findConsole(3); // trying to find the deleted console

        assertNull(consoleViewModel);
    }

    @Test
    public void getConsoleByManufacturer(){

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        //adding the first console from save Console
        // from the ConsoleDaoMock without the id


        consoleViewModel.setModel("Matrix");
        consoleViewModel.setManufacturer("Matrix Man");
        consoleViewModel.setMemoryAmount("500MB");
        consoleViewModel.setProcessor("G7");
        consoleViewModel.setPrice(new BigDecimal("29.99"));
        consoleViewModel.setQuantity(5);

        consoleViewModel = service.saveConsole(consoleViewModel); //adding into service

        List<ConsoleViewModel> byManufacturer= service.findConsoleByManufacturer("Matrix Man");

        assertEquals(1,byManufacturer.size());

        byManufacturer= service.findConsoleByManufacturer("Fake manufacturer");
        assertEquals(0,byManufacturer.size());

    }

    /******************************* End of ConsoleDaoMockTest  ******************************/

    @Test
    public void saveInvoice(){

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();

        invoiceViewModel.setName("Opu");
        invoiceViewModel.setStreet("197th");
        invoiceViewModel.setCity("Jamaica");
        invoiceViewModel.setState("NY");
        invoiceViewModel.setZipCode("11423");
        invoiceViewModel.setItemType("consoles");
        invoiceViewModel.setItemId(1);
        invoiceViewModel.setUnitPrice(new BigDecimal("19.99"));
        invoiceViewModel.setQuantity(5);

        invoiceViewModel = service.saveInvoice(invoiceViewModel); //saving to the service and put it again in invoiceViewModel
        InvoiceViewModel fromService= service.findInvoice(invoiceViewModel.getInvoiceId());

        assertEquals(invoiceViewModel,fromService);
    }

    @Test
    public void  findInvoice(){

        //taking the Invoice from the add Invoice from ConsoleDaoMock

        Invoice invoice = new Invoice();

        invoice.setInvoiceId(1);
        invoice.setName("Opu");
        invoice.setStreet("197th");
        invoice.setCity("Jamaica");
        invoice.setState("NY");
        invoice.setZipCode("11423");
        invoice.setItemType("consoles");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("29.99"));
        invoice.setQuantity(5);

        invoice.setSubtotal(new BigDecimal("149.95"));

        invoice.setTax(new BigDecimal("9.00"));

        invoice.setProcessingFee(new BigDecimal("1.49"));

        invoice.setTotal(new BigDecimal("160.44"));

        //adding the invoice to the  InvoiceViewModel
        InvoiceViewModel invoiceViewModel = service.findInvoice(1);

        //creating another invoice object and passing the invoiceViewModel to compare

        Invoice invoice1 = new Invoice();

        invoice1.setInvoiceId(invoiceViewModel.getInvoiceId());
        invoice1.setName(invoiceViewModel.getName());
        invoice1.setStreet(invoiceViewModel.getStreet());
        invoice1.setCity(invoiceViewModel.getCity());
        invoice1.setState(invoiceViewModel.getState());
        invoice1.setZipCode(invoiceViewModel.getZipCode());
        invoice1.setItemType(invoiceViewModel.getItemType());
        invoice1.setItemId(invoiceViewModel.getItemId());
        invoice1.setUnitPrice(invoiceViewModel.getUnitPrice());
        invoice1.setQuantity(invoiceViewModel.getQuantity());

        invoice1.setSubtotal(invoiceViewModel.getSubtotal());

        invoice1.setTax(invoiceViewModel.getTax());

        invoice1.setProcessingFee(invoiceViewModel.getProcessingFee());

        invoice1.setTotal(invoiceViewModel.getTotal());

        assertEquals(invoice1,invoice);

    }

    @Test
    public void findAllInvoices(){
        //getting all the invoices from the invoiceViewModel

        List<InvoiceViewModel> fromService= service.findAllInvoices();

        assertEquals(1,fromService.size());
    }

    @Test
    public void updateInvoice(){

        InvoiceViewModel invoiceViewUpdate= new InvoiceViewModel();

        //creating a invoice to update
        //taking the same invoice from the update chunk from InvoiceDaoMock

        Invoice updateInvoice = new Invoice();

        updateInvoice.setInvoiceId(2);
        updateInvoice.setName("Opu Updated");
        updateInvoice.setStreet("197th Updated");
        updateInvoice.setCity("Jamaica Updated");
        updateInvoice.setState("NY");
        updateInvoice.setZipCode("11423");
        updateInvoice.setItemType("consoles");
        updateInvoice.setItemId(37);
        updateInvoice.setUnitPrice(new BigDecimal("19.99"));
        updateInvoice.setQuantity(5);

        updateInvoice.setSubtotal(new BigDecimal("99.95"));

        updateInvoice.setTax(new BigDecimal("0.06"));

        updateInvoice.setProcessingFee(new BigDecimal("1.49"));

        updateInvoice.setTotal(new BigDecimal("107.44"));

        //passing the invoice into the InvoiceViewModel

        invoiceViewUpdate.setInvoiceId(updateInvoice.getInvoiceId());
        invoiceViewUpdate.setName(updateInvoice.getName());
        invoiceViewUpdate.setStreet(updateInvoice.getStreet());
        invoiceViewUpdate.setCity(updateInvoice.getCity());
        invoiceViewUpdate.setState(updateInvoice.getState());
        invoiceViewUpdate.setZipCode(updateInvoice.getZipCode());
        invoiceViewUpdate.setItemType(updateInvoice.getItemType());
        invoiceViewUpdate.setItemId(updateInvoice.getItemId());
        invoiceViewUpdate.setUnitPrice(updateInvoice.getUnitPrice());
        invoiceViewUpdate.setQuantity(updateInvoice.getQuantity());

        invoiceViewUpdate.setSubtotal(updateInvoice.getSubtotal());

        invoiceViewUpdate.setTax(updateInvoice.getTax());

        invoiceViewUpdate.setProcessingFee(updateInvoice.getProcessingFee());

        invoiceViewUpdate.setTotal(updateInvoice.getTotal());

        service.updateInvoice(invoiceViewUpdate);

        //finding the invoice we just updated

        InvoiceViewModel invoiceViewModel = service.findInvoice(invoiceViewUpdate.getInvoiceId());

        Invoice invoiceAfterUpdate = new Invoice();

        invoiceAfterUpdate.setInvoiceId(invoiceViewModel.getInvoiceId());
        invoiceAfterUpdate.setName(invoiceViewModel.getName());
        invoiceAfterUpdate.setStreet(invoiceViewModel.getStreet());
        invoiceAfterUpdate.setCity(invoiceViewModel.getCity());
        invoiceAfterUpdate.setState(invoiceViewModel.getState());
        invoiceAfterUpdate.setZipCode(invoiceViewModel.getZipCode());
        invoiceAfterUpdate.setItemType(invoiceViewModel.getItemType());
        invoiceAfterUpdate.setItemId(invoiceViewModel.getItemId());
        invoiceAfterUpdate.setUnitPrice(invoiceViewModel.getUnitPrice());
        invoiceAfterUpdate.setQuantity(invoiceViewModel.getQuantity());

        invoiceAfterUpdate.setSubtotal(invoiceViewModel.getSubtotal());

        invoiceAfterUpdate.setTax(invoiceViewModel.getTax());

        invoiceAfterUpdate.setProcessingFee(invoiceViewModel.getProcessingFee());

        invoiceAfterUpdate.setTotal(invoiceViewModel.getTotal());

        //comparing both
        assertEquals(invoiceAfterUpdate,updateInvoice);

    }

    @Test
    public void removeInvoice(){

        //taking the invoice id from the remove chunk from InvoiceDaoMock
        service.removeInvoice(3);

        InvoiceViewModel invoiceViewModel = service.findInvoice(3); // trying to find the deleted invoice

        assertNull(invoiceViewModel);
    }


    /******************************* End of InvoiceDaoMockTest  ******************************/






    /********************************** DAO MOCK ***********************************/
    /********************************** DAO MOCK ***********************************/

    private void setUpSalesTaxRateDaoMock(){
        //creating a mock object for SalesTaxRateDaoJdbcTemplate
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        //Mock the get SalesTaxRate
        SalesTaxRate salesTaxRate = new SalesTaxRate();

        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal(0.06));

        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NY");
    }

    private void setUpProcessingFeeDaoMock(){
        //creating a mock object for ProcessingFeeDaoJdbcTemplate
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        //Mock the get ProcessingFee
        ProcessingFee processingFee = new ProcessingFee();

        processingFee.setProductType("consoles");
        processingFee.setFee(new BigDecimal("1.49"));
        doReturn(processingFee).when(processingFeeDao).getProcessingFee("consoles");

    }

    private void setUpGameDaoMock(){

        //creating a mock object for GameDaoJdbcTemplateImpl
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        //Mock add game

        Game game = new Game();

        game.setGameId(1);
        game.setTitle("Resident Evil");
        game.setEsrbRating("M1");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Press");
        game.setQuantity(5);

        //creating another game1 object with the same data but without the id
        Game game1 = new Game();


        game1.setTitle("Resident Evil");
        game1.setEsrbRating("M1");
        game1.setDescription("Action");
        game1.setPrice(new BigDecimal("19.99"));
        game1.setStudio("Press");
        game1.setQuantity(5);

        doReturn(game).when(gameDao).addGame(game1);

        //Mock get Game
        doReturn(game).when(gameDao).getGame(1); // same game id in the add game

        //Mock getAll Game
        List<Game> gameList = new ArrayList<>();

        gameList.add(game);

        doReturn(gameList).when(gameDao).getAllGames();

        //Mock the update Game

        Game updateGame = new Game();

        updateGame.setGameId(2);
        updateGame.setTitle("Resident Updated");
        updateGame.setEsrbRating("M1 Updated");
        updateGame.setDescription("Action Updated");
        updateGame.setPrice(new BigDecimal("19.99"));
        updateGame.setStudio("Press");
        updateGame.setQuantity(5);

        doNothing().when(gameDao).updateGame(updateGame);
        doReturn(updateGame).when(gameDao).getGame(2);

        //Mock the remove Game

        Game deleteGame = new Game();

        deleteGame.setGameId(3);
        deleteGame.setTitle("Resident Deleted");
        deleteGame.setEsrbRating("M1 Deleted");
        deleteGame.setDescription("Action Deleted");
        deleteGame.setPrice(new BigDecimal("19.99"));
        deleteGame.setStudio("Press");
        deleteGame.setQuantity(5);

        doNothing().when(gameDao).deleteGame(3);
        doReturn(null).when(gameDao).getGame(3);

        //Mock the get Games By Studio
        doReturn(gameList).when(gameDao).getGamesByStudio("Press"); // using the save game data

        //Mock the get Game by ESRB Ratings
        doReturn(gameList).when(gameDao).getGamesByESRBRatings("M1");//using the save game data

        //Mock the get game by title
        doReturn(gameList).when(gameDao).getGamesByTitle("Resident Evil");

    }

    /******************************* End of Game Dao Mock  ******************************/

    private void setUpTShirtDaoMock(){

        //creating a mock object for TShirtDaoJdbcTemplateImpl
        tShirtsDao =mock(TShirtDaoJdbcTemplateImpl.class);

        //Mock Add T Shirt

        TShirt tShirt = new TShirt();

        tShirt.settShirtId(1);
        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V-Neck");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(5);

        //creating another t Shirt with the same data without the id

        TShirt tShirt1 = new TShirt();

        tShirt1.setSize("M");
        tShirt1.setColor("Black");
        tShirt1.setDescription("V-Neck");
        tShirt1.setPrice(new BigDecimal("19.99"));
        tShirt1.setQuantity(5);

        doReturn(tShirt).when(tShirtsDao).addTShirt(tShirt1);

        //Mock the get TShirt
        doReturn(tShirt).when(tShirtsDao).getTShirt(1); // same id in the add TShirt

        //Mock the getAll T Shirt
        List<TShirt> tShirtList = new ArrayList<>();

        tShirtList.add(tShirt);

        doReturn(tShirtList).when(tShirtsDao).getAllTShirts();

        //Mock the Update T Shirt

        TShirt updateTShirt= new TShirt();

        updateTShirt.settShirtId(2);
        updateTShirt.setSize("M Updated");
        updateTShirt.setColor("Black Updated");
        updateTShirt.setDescription("V-Neck Updated");
        updateTShirt.setPrice(new BigDecimal("19.99"));
        updateTShirt.setQuantity(5);

        doNothing().when(tShirtsDao).updateTShirt(updateTShirt);

        doReturn(updateTShirt).when(tShirtsDao).getTShirt(2);

        //Mock the remove T shirt

        TShirt deleteTShirt = new TShirt();

        deleteTShirt.settShirtId(3);
        deleteTShirt.setSize("M deleted");
        deleteTShirt.setColor("Black deleted");
        deleteTShirt.setDescription("V-Neck deleted");
        deleteTShirt.setPrice(new BigDecimal("19.99"));
        deleteTShirt.setQuantity(5);

        doNothing().when(tShirtsDao).deleteTShirt(3);
        doReturn(null).when(tShirtsDao).getTShirt(3);  //passing the delete tShirt id which should be null

        //Mock the get TShirt By Color

        doReturn(tShirtList).when(tShirtsDao).getTShirtsByColor("Black"); // using the color from add TShirt data

        // Mock get T Shirt By Size

        doReturn(tShirtList).when(tShirtsDao).getTShirtBySize("M"); // using the size from the add TShirt data

    }

    /******************************* End of T Shirt Dao Mock  ******************************/

    private void setUpConsoleDaoMock(){

        //Creating a mock object for ConsoleJdbcTemplateImpl

        consoleDao= mock(ConsoleDaoJdbcTemplateImpl.class);

        //Mock add console

        Console console = new Console();

        console.setConsoleId(1);
        console.setModel("Matrix");
        console.setManufacturer("Matrix Man");
        console.setMemoryAmount("500MB");
        console.setProcessor("G7");
        console.setPrice(new BigDecimal("29.99"));
        console.setQuantity(5);

        //creating another console1 object with the same data without id

        Console console1 = new Console();


        console1.setModel("Matrix");
        console1.setManufacturer("Matrix Man");
        console1.setMemoryAmount("500MB");
        console1.setProcessor("G7");
        console1.setPrice(new BigDecimal("29.99"));
        console1.setQuantity(5);

        doReturn(console).when(consoleDao).addConsole(console1);

        //Mock the get Console

        doReturn(console).when(consoleDao).getConsole(1); // same console id in the add console


        //Mock the getAll Consoles
        List<Console> consoleList = new ArrayList<>();

        consoleList.add(console);

        doReturn(consoleList).when(consoleDao).getAllConsoles();

        //Mock the update console

        Console updateConsole= new Console();

        updateConsole.setConsoleId(2);
        updateConsole.setModel("Matrix Updated");
        updateConsole.setManufacturer("Matrix Man Updated");
        updateConsole.setMemoryAmount("500MB");
        updateConsole.setProcessor("G7");
        updateConsole.setPrice(new BigDecimal("29.99"));
        updateConsole.setQuantity(5);

        doNothing().when(consoleDao).updateConsole(updateConsole);
        doReturn(updateConsole).when(consoleDao).getConsole(2);

        //Mock the remove console

        Console deleteConsole= new Console();

        deleteConsole.setConsoleId(3);
        deleteConsole.setModel("Matrix deleted");
        deleteConsole.setManufacturer("Matrix Man Deleted");
        deleteConsole.setMemoryAmount("500MB");
        deleteConsole.setProcessor("G7");
        deleteConsole.setPrice(new BigDecimal("29.99"));
        deleteConsole.setQuantity(5);

        doNothing().when(consoleDao).deleteConsole(3);
        doReturn(null).when(consoleDao).getConsole(3);

        //Mock the get ConsoleByManufacturer

        doReturn(consoleList).when(consoleDao).getConsoleByManufacturer("Matrix Man"); // using the add console data
    }

    /******************************* End of Console Dao Mock  ******************************/

    private void setUpInvoiceDaoMock(){


        //Creating a Mock object for InvoiceJdbcTemplateImpl

        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);


        // Mock add Invoice

        Invoice invoice = new Invoice();

        invoice.setInvoiceId(1);
        invoice.setName("Opu");
        invoice.setStreet("197th");
        invoice.setCity("Jamaica");
        invoice.setState("NY");
        invoice.setZipCode("11423");
        invoice.setItemType("consoles");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("29.99"));
        invoice.setQuantity(5);

        invoice.setSubtotal(new BigDecimal("149.95"));

        invoice.setTax(new BigDecimal("9.00"));

        invoice.setProcessingFee(new BigDecimal("1.49"));

        invoice.setTotal(new BigDecimal("160.44"));
        //creating another invoice object with the same data without id

        Invoice invoice1 = new Invoice();

        invoice1.setName("Opu");
        invoice1.setStreet("197th");
        invoice1.setCity("Jamaica");
        invoice1.setState("NY");
        invoice1.setZipCode("11423");
        invoice1.setItemType("consoles");
        invoice1.setItemId(1);
        invoice1.setUnitPrice(new BigDecimal("29.99"));
        invoice1.setQuantity(5);


        invoice1.setSubtotal(invoice.getSubtotal());

        invoice1.setTax(invoice.getTax());

        invoice1.setProcessingFee(invoice.getProcessingFee());

        invoice1.setTotal(invoice.getTotal());

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);

        //Mock the get Invoice

        doReturn(invoice).when(invoiceDao).getInvoice(1); //same invoice id we used to add Mock

        //Mock the getAll invoices

        List<Invoice> invoiceList = new ArrayList<>();

        invoiceList.add(invoice);

        doReturn(invoiceList).when(invoiceDao).getAllInvoices();

        //Mock the updateInvoice

        Invoice updateInvoice = new Invoice();

        updateInvoice.setInvoiceId(2);
        updateInvoice.setName("Opu Updated");
        updateInvoice.setStreet("197th Updated");
        updateInvoice.setCity("Jamaica Updated");
        updateInvoice.setState("NY");
        updateInvoice.setZipCode("11423");
        updateInvoice.setItemType("consoles");
        updateInvoice.setItemId(37);
        updateInvoice.setUnitPrice(new BigDecimal("19.99"));
        updateInvoice.setQuantity(5);

        updateInvoice.setSubtotal(new BigDecimal("99.95"));

        updateInvoice.setTax(new BigDecimal("0.06"));

        updateInvoice.setProcessingFee(new BigDecimal("1.49"));

        updateInvoice.setTotal(new BigDecimal("107.44"));

        doNothing().when(invoiceDao).updateInvoice(updateInvoice);
        doReturn(updateInvoice).when(invoiceDao).getInvoice(2);

        //Mock the remove invoice

        Invoice deleteInvoice = new Invoice();

        deleteInvoice.setInvoiceId(3);
        deleteInvoice.setName("Opu Deleted");
        deleteInvoice.setStreet("197th Deleted");
        deleteInvoice.setCity("Jamaica Deleted");
        deleteInvoice.setState("NY");
        deleteInvoice.setZipCode("11423");
        deleteInvoice.setItemType("consoles");
        deleteInvoice.setItemId(37);
        deleteInvoice.setUnitPrice(new BigDecimal("19.99"));
        deleteInvoice.setQuantity(5);

        deleteInvoice.setSubtotal(invoice.getUnitPrice().multiply(new BigDecimal(invoice.getQuantity())));

        deleteInvoice.setTax(new BigDecimal("0.06"));     /**********DO WE NEED TO CHECK WITH OUR METHOD*****/

        deleteInvoice.setProcessingFee(new BigDecimal("1.49"));   /**********DO WE NEED TO CHECK WITH OUR METHOD*****/

        deleteInvoice.setTotal(invoice.getTotal());

        doNothing().when(invoiceDao).deleteInvoice(3);
        doReturn(null).when(invoiceDao).getInvoice(3); //trying to get the deleted invoice

    }

    /******************************* End of Invoice Dao Mock  ******************************/

}
