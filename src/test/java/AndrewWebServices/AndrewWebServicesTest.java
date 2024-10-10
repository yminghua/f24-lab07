package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService mockPromoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // database = new Database(); // We probably don't want to access our real database...
        database = new InMemoryDatabase();  // Fake
        // recommender = new RecSys();
        recommender = new RecSysStub(); // Stub
        mockPromoService = mock(PromoService.class);  // Mock object

        andrewWebService = new AndrewWebServices(database, recommender, mockPromoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        andrewWebService.sendPromoEmail("test@gmail.com");
        verify(mockPromoService).mailTo("test@gmail.com");
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        andrewWebService.logIn("Scotty", 17214);
        verify(mockPromoService, never()).mailTo("Scotty@gmail.com");
    }
}
