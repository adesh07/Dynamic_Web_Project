package in.co.rays.test;

import java.util.Iterator;
import java.util.List;
import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class UserTest {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testDelete();
		 testSearch();
		// testUpdate();
		// testDynamicSearch();

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();
		model.delete(7);

	}

	public static void testAdd() throws Exception {

		UserBean bean = new UserBean();

		bean.setFirstName("Pushpa");
		bean.setLastName("Konut");
		bean.setloginId("pushpa@gmail.com");
		bean.setPassword("pushpa@123");
		bean.setAddress("Indore");

		UserModel model = new UserModel();
		model.add(bean);

	}

	public static void testSearch() throws Exception {

		UserModel model = new UserModel();
		List list = model.search();

		Iterator itt = list.iterator();

		while (itt.hasNext()) {

			UserBean bean = (UserBean) itt.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getloginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getAddress());

		}

	}

	public static void testUpdate() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(5);
		bean.setFirstName("Mogambo");
		bean.setLastName("Shakal");

		UserModel model = new UserModel();
		model.Update(bean);
	}

	public static void testDynamicSearch() throws Exception {

		UserBean bean = new UserBean();
		// bean.setId(2);
		bean.setFirstName("P");

		UserModel model = new UserModel();
		List list = model.dynamicSearch(bean);

		Iterator itt = list.iterator();

		bean = new UserBean();
		while (itt.hasNext()) {

			bean = (UserBean) itt.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getloginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getAddress());

		}
	}
}
