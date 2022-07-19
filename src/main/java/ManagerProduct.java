public class ManagerProduct {

    private RepoProduct repo = new RepoProduct();

    public ManagerProduct(RepoProduct repo) {
        this.repo = repo;
    }

    public ManagerProduct() {

    }

    public void add(Product productNew) {
        Product[] tmp = new Product[repo.getAll().length + 1];

        for (int i = 0; i < repo.getAll().length; i++) {
            if (repo.products[i].getId() == productNew.getId()) {
                throw new AlreadyExistsException("Element with id: " + productNew.id + " already exists");
            }
            tmp[i] = repo.products[i];
        }
        tmp[tmp.length - 1] = productNew;
        repo.products = tmp;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
