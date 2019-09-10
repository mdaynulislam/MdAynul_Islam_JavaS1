package com.company.MdAynulIslamU1Capstone.service;

import com.company.MdAynulIslamU1Capstone.dao.*;
import com.company.MdAynulIslamU1Capstone.model.*;
import com.company.MdAynulIslamU1Capstone.viewModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameInventoryService {

    private GameDao gameDao;
    private ConsoleDao consoleDao;
    private TShirtsDao tShirtsDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;


    //constructor

    public GameInventoryService(GameDao gameDao, ConsoleDao consoleDao,
                                TShirtsDao tShirtsDao, InvoiceDao invoiceDao,
                                ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao) {
        this.gameDao = gameDao;
        this.consoleDao = consoleDao;
        this.tShirtsDao = tShirtsDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;

    }

    /*****************************For Game *********************/
    //
    @Transactional
    public GameViewModel saveGame(GameViewModel gameViewModel){
        //without the game id
        Game game = new Game();

        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        game= gameDao.addGame(game);

        gameViewModel.setGameId(game.getGameId());

        return gameViewModel;
    }

    public GameViewModel findGame(int id){

        Game game = gameDao.getGame(id);

        if(game == null)
            return null;
        else
            return buildGameViewModel(game);

    }

    public List<GameViewModel> findAllGames(){
        List <Game> gameList = gameDao.getAllGames();

        List<GameViewModel> gameViewModelList = new ArrayList<>();

        for(Game game : gameList){
            gameViewModelList.add(buildGameViewModel(game));
        }
        return gameViewModelList;
    }

    @Transactional
    public void updateGame(GameViewModel gameViewModel){
        //with the id
        Game game = new Game();

        game.setGameId(gameViewModel.getGameId());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        gameDao.updateGame(game);

    }

    public void removeGame(int id){
        gameDao.deleteGame(id);
    }

    public  List<GameViewModel> findGamesByStudio(String studio){

        List<Game> gameList = gameDao.getGamesByStudio(studio);

        List<GameViewModel> gameViewModelList = new ArrayList<>();

        for(Game game: gameList){
            gameViewModelList.add(buildGameViewModel(game));
        }
        return gameViewModelList;
    }

    public List<GameViewModel> findGamesByESRBRatings(String esrbRatings){

        List<Game> gameList= gameDao.getGamesByESRBRatings(esrbRatings);

        List<GameViewModel> gameViewModelList=new ArrayList<>();

        for(Game game: gameList){
            gameViewModelList.add(buildGameViewModel(game));
        }
        return gameViewModelList;
    }

    public List<GameViewModel> findGamesByTitle(String title){

        List<Game> gameList =gameDao.getGamesByTitle(title);

        List<GameViewModel> gameViewModelList = new ArrayList<>();

        for(Game game: gameList){
            gameViewModelList.add(buildGameViewModel(game));
        }
        return gameViewModelList;
    }


    //
    /**********************************Console ***********************************/
    //
    @Transactional
    public  ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel){

        //without the id
        Console console = new Console();

        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        console = consoleDao.addConsole(console);

        consoleViewModel.setConsoleId(console.getConsoleId());

        return consoleViewModel;

    }

    public ConsoleViewModel findConsole(int id){

        Console console = consoleDao.getConsole(id);

        if(console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public List<ConsoleViewModel> findAllConsoles(){
        List<Console> consoleList = consoleDao.getAllConsoles();

        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();

        for(Console console: consoleList){
            consoleViewModelList.add(buildConsoleViewModel(console));
        }
        return consoleViewModelList;
    }

    @Transactional
    public void updateConsole(ConsoleViewModel consoleViewModel){

        //with the id
        Console console = new Console();

        console.setConsoleId(consoleViewModel.getConsoleId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        consoleDao.updateConsole(console);

    }

    public void removeConsole(int id){
        consoleDao.deleteConsole(id);
    }

    public List<ConsoleViewModel> findConsoleByManufacturer(String manufacturer){

        List<Console> consoleList =consoleDao.getConsoleByManufacturer(manufacturer);

        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();

        for(Console console: consoleList){

            consoleViewModelList.add(buildConsoleViewModel(console));
        }
        return consoleViewModelList;
    }

    //
    /*************************** T Shirt ****************************/
    //
    @Transactional
    public TShirtViewModel saveTShirt(TShirtViewModel tShirtViewModel){
        // without the T Shirt id
        TShirt tShirt = new TShirt();

        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirt = tShirtsDao.addTShirt(tShirt);

        tShirtViewModel.settShirtId(tShirt.gettShirtId());

        return tShirtViewModel;
    }

    public TShirtViewModel findTShirt(int id){

        TShirt tShirt = tShirtsDao.getTShirt(id);

        if(tShirt == null)
            return null;
        else
            return buildTShirtViewModel(tShirt);

    }

    public List<TShirtViewModel> findAllTShirts(){

        List<TShirt> tShirtList = tShirtsDao.getAllTShirts();

        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();

        for (TShirt tShirt : tShirtList){
            tShirtViewModelList.add(buildTShirtViewModel(tShirt));
        }
        return tShirtViewModelList;
    }

    @Transactional
    public void updateTShirt(TShirtViewModel tShirtViewModel){

        // with the id

        TShirt tShirt = new TShirt();

        tShirt.settShirtId(tShirtViewModel.gettShirtId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());

        tShirtsDao.updateTShirt(tShirt);

    }

    public void removeTShirt(int id){
        tShirtsDao.deleteTShirt(id);
    }

    public List<TShirtViewModel> findTShirtsByColor(String color){

        List<TShirt> tShirtList = tShirtsDao.getTShirtsByColor(color);

        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();

        for(TShirt tShirt : tShirtList){
            tShirtViewModelList.add(buildTShirtViewModel(tShirt));
        }
        return tShirtViewModelList;
    }

    public List<TShirtViewModel> findTShirtsBySize(String size){

        List<TShirt> tShirtList = tShirtsDao.getTShirtBySize(size);

        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();

        for(TShirt tShirt: tShirtList){

            tShirtViewModelList.add(buildTShirtViewModel(tShirt));
        }
        return tShirtViewModelList;
    }

    //
    /***********************************Invoice***********************************/
    //

    //Calculating the Tax

    private BigDecimal calculateTax(BigDecimal subtotal, String state)
    {
        SalesTaxRate salesTaxRate= salesTaxRateDao.getSalesTaxRate(state);

        BigDecimal tax = subtotal.multiply(salesTaxRate.getRate()).setScale(2, RoundingMode.CEILING);
        return tax;
    }

    //Calculating the processing fee
     private BigDecimal calculateProcessingFee(String itemType, int quantity)
     {
         ProcessingFee processingFee=processingFeeDao.getProcessingFee(itemType);

         BigDecimal fee = processingFee.getFee();
         if(quantity >= 10){                     //Business Logic
             fee.add(new BigDecimal("15.49"));
         }
         return fee.setScale(2,RoundingMode.CEILING);
     }
        //Calculating the total
     private BigDecimal calculateTotal(BigDecimal subtotal, BigDecimal tax, BigDecimal processingFee) {
        BigDecimal postTax = subtotal.add(tax);
        return postTax.add(processingFee);
     }
    //calculating the Subtotal
     private BigDecimal calculateSubTotal(int quantity, BigDecimal price) {
        BigDecimal subTotal = price.multiply(new BigDecimal(quantity));
        return subTotal;
     }
    //calculating the getItemPrice

    private BigDecimal getItemPrice(int id, String itemType) {
        BigDecimal price = new BigDecimal("00.00");
        String fixedItemType = itemType.toLowerCase();

        switch (fixedItemType) {
            case "consoles":
                Console console = consoleDao.getConsole(id);
                price = console.getPrice();
                break;
            case "t-shirts":
                TShirt tShirt = tShirtsDao.getTShirt(id);
                price = tShirt.getPrice();
                break;
            case "games":
                Game game = gameDao.getGame(id);
                price = game.getPrice();
                break;
            default:
                break;
        }
        return price;
    }
    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){

        //without the id
        Invoice invoice = new Invoice();

        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipCode(invoiceViewModel.getZipCode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());

        invoice.setQuantity(invoiceViewModel.getQuantity());

        /**************************************************For the Inventory check ***************************************************/

        if (invoice.getItemType().equals("consoles")) {
            Console item = consoleDao.getConsole(invoice.getItemId());
            int itemQuantity = item.getQuantity();


            if (invoice.getQuantity() > itemQuantity) {
                throw new IllegalArgumentException("Short on inventory.");
            } else {
                item.setQuantity(itemQuantity - invoice.getQuantity());
                consoleDao.updateConsole(item);
            }
        } else if (invoice.getItemType().equals("T-shirts")) {
            TShirt item = tShirtsDao.getTShirt(invoice.getItemId());
            int itemQuantity = item.getQuantity();


            if (invoice.getQuantity() > itemQuantity) {
                throw new IllegalArgumentException("Short on inventory.");
            } else {
                item.setQuantity(itemQuantity - invoice.getQuantity());
                tShirtsDao.updateTShirt(item);
            }
        } else if (invoice.getItemType().equals("games")) {
            Game item = gameDao.getGame(invoice.getItemId());
            int itemQuantity = item.getQuantity();

            if (invoice.getQuantity() > itemQuantity) {
                throw new IllegalArgumentException("Short on inventory.");
            } else {
                item.setQuantity(itemQuantity - invoice.getQuantity());
                gameDao.updateGame(item);
            }
        } else {
            throw new IllegalArgumentException("Incorrect Input! Choose either [consoles] or [games] or [T-shirts]");
        }

        /************************************************************ Inventory Check Ends ******************************************************/


        //PERFORM CALCULATIONS
        BigDecimal unitPrice = getItemPrice(invoiceViewModel.getItemId(), invoiceViewModel.getItemType());
        BigDecimal subTotal = calculateSubTotal(invoiceViewModel.getQuantity(), unitPrice);
        BigDecimal processingFee= calculateProcessingFee(invoice.getItemType(),invoice.getQuantity());
        BigDecimal tax= calculateTax(subTotal,invoice.getState());
        BigDecimal total = calculateTotal(subTotal, tax, processingFee);

        // SET VALUES AFTER CALCULATION
        invoice.setUnitPrice(unitPrice);
        invoice.setSubtotal(subTotal);        //NEED CHECK invoice.setSubtotal(invoiceViewModel.getSubtotal());
        invoice.setTax(tax);         // NEED CHECKING  // invoice.setTax(invoiceViewModel.getTax)
        invoice.setProcessingFee(processingFee);          // NEED CHECKING invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
        invoice.setTotal(total);

        invoice = invoiceDao.addInvoice(invoice);

        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel = buildInvoiceViewModel(invoice);

        return invoiceViewModel;

    }

    public InvoiceViewModel findInvoice(int id){

        Invoice invoice =invoiceDao.getInvoice(id);

        if(invoice == null)
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }

    public List<InvoiceViewModel> findAllInvoices(){

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        List<InvoiceViewModel> invoiceViewModelList = new ArrayList<>();

        for(Invoice invoice: invoiceList){
            invoiceViewModelList.add(buildInvoiceViewModel(invoice));
        }
        return invoiceViewModelList;
    }

    @Transactional
    public  void updateInvoice(InvoiceViewModel invoiceViewModel){

        //with the id
        Invoice invoice = new Invoice();

        invoice.setInvoiceId(invoiceViewModel.getInvoiceId());
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipCode(invoiceViewModel.getZipCode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setUnitPrice(invoiceViewModel.getUnitPrice());
        invoice.setQuantity(invoiceViewModel.getQuantity());

        invoice.setSubtotal(invoiceViewModel.getSubtotal());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
        invoice.setTotal(invoiceViewModel.getTotal());

        invoiceDao.updateInvoice(invoice);

    }

    public void removeInvoice(int id){
        invoiceDao.deleteInvoice(id);
    }



    /*******************************Helper Method*******************************************/
    /*******************************Helper Method******************************************/

    /***************************For GAME************************/

    private GameViewModel buildGameViewModel(Game game){

        GameViewModel gameViewModel=new GameViewModel();

        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setEsrbRating(game.getEsrbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;

    }

    /*************************** For T Shirt ************************/

    private TShirtViewModel buildTShirtViewModel(TShirt tShirt){

        TShirtViewModel tShirtViewModel =new TShirtViewModel();

        tShirtViewModel.settShirtId(tShirt.gettShirtId());
        tShirtViewModel.setSize(tShirt.getSize());
        tShirtViewModel.setColor(tShirt.getColor());
        tShirtViewModel.setDescription(tShirt.getDescription());
        tShirtViewModel.setPrice(tShirt.getPrice());
        tShirtViewModel.setQuantity(tShirt.getQuantity());

        return tShirtViewModel;

    }

    /****************************** For Console ***********************/

    private ConsoleViewModel buildConsoleViewModel(Console console){

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        consoleViewModel.setConsoleId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;

    }

    /***************************** For Invoice *************************/

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice){

        InvoiceViewModel invoiceViewModel =new InvoiceViewModel();

        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());

        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipCode(invoice.getZipCode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setQuantity(invoice.getQuantity());

        //Below is my calculation
        invoiceViewModel.setSubtotal(invoice.getSubtotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }

}
