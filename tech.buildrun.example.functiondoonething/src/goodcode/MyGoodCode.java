package goodcode;

import badcode.MyBadCode;
import common.Product;
import common.ProductPackage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyGoodCode {

    private static final Logger logger = Logger.getLogger(MyGoodCode.class.getName());

    public static void main(String[] args) {

        var product = new Product("Computer");

        var packageId = packageProduct(product);

        deliverPackage(packageId);
    }

    private static String packageProduct(Product product) {
        var productPackage =
                new ProductPackage(List.of(product));

        return notifyPackageSystem(productPackage);
    }

    private static void deliverPackage(String packageId) {
        notifyDeliverySystem(packageId,
                "AVAILABLE");

        scheduleDelivery(
                packageId,
                nextWeek()
        );
    }

    private static String notifyPackageSystem(ProductPackage productPackage) {
        return UUID.randomUUID().toString();
    }

    private static void notifyDeliverySystem(String packageId,
                                             String status) {
        logger.log(Level.INFO, "New Package " +
                        "Status: {0}",
                List.of(packageId, status)
        );
    }

    private static void scheduleDelivery(String packageId,
                                         LocalDate deliveryDate) {
        logger.log(Level.INFO, "New Package " +
                        "to be delivered: " +
                        "{0}",
                List.of(packageId, deliveryDate)
        );
    }

    private static LocalDate nextWeek() {
        return LocalDate.now().plus(7, ChronoUnit.DAYS);
    }


}
