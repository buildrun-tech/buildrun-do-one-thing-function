package badcode;

import common.ProductPackage;
import common.Product;
import common.Status;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyBadCode {

    private static final Logger logger = Logger.getLogger(MyBadCode.class.getName());

    public static void main(String[] args) {

        var product = new Product("Computer");

        packageAndDelivery(product);
    }

    private static void packageAndDelivery(Product product) {

        var productPackage =
                new ProductPackage(List.of(product));

        var packageId =
                notifyPackageSystem(productPackage);

        notifyDeliverySystem(packageId,
                Status.AVAILABLE);

        scheduleDelivery(
                packageId,
                nextWeek()
        );
    }

    private static String notifyPackageSystem(ProductPackage productPackage) {
        return UUID.randomUUID().toString();
    }

    private static void notifyDeliverySystem(String packageId,
                                             Status status) {
        logger.log(Level.INFO, "New Package " +
                "Status: {0}",
                List.of(packageId, status.name())
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
