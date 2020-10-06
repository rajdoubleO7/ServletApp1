package DOA;

import java.util.List;

import Model.Product;

public interface ProductRepo {
	int add(Product p);
	int delete(int pid);
	int update(Product p);
	List showAll();
}
