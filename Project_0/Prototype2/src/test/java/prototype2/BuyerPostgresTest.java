package prototype2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Buyer;
import com.revature.repositories.BuyerDao;
import com.revature.repositories.BuyerPostgres;

@ExtendWith(MockitoExtension.class)
public class BuyerPostgresTest {
	
	@Mock
	private BuyerDao bd;
	
	@InjectMocks
	private BuyerPostgres bp;
	
	@Test
	public void addBuyerValid() {
		//Buyer test = null;
		//Buyer test = ;
		Mockito.when(bd.add(new Buyer("YumYum","sixer","Seb"))).thenReturn(new Buyer("YumYum","sixer","Seb", 19));
		
		Buyer expected = new Buyer("YumYum","sixer","Seb", 19);
		Buyer actual = bp.add(new Buyer("YumYum","sixer","Seb"));
		assertEquals(expected, actual);
	}

}
