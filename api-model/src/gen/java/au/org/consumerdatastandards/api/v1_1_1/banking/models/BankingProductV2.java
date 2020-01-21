package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.time.OffsetDateTime;
import java.util.List;

@DataDefinition
public class BankingProductV2 {

    @Property(
        description = "A data holder specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.",
        required = true
    )
    @CDSDataType(CustomDataType.ASCII)
    String productId;

    @Property(
        description = "The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate"
    )
    @CDSDataType(CustomDataType.DateTime)
    OffsetDateTime effectiveFrom;

    @Property(
        description = "The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products"
    )
    @CDSDataType(CustomDataType.DateTime)
    OffsetDateTime effectiveTo;

    @Property(
        description = "The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)",
        required = true
    )
    @CDSDataType(CustomDataType.DateTime)
    OffsetDateTime lastUpdated;

    @Property(
        required = true
    )
    BankingProductCategory productCategory;

    @Property(
        description = "The display name of the product",
        required = true
    )
    String name;

    @Property(
        description = "A description of the product",
        required = true
    )
    String description;

    @Property(
        description = "A label of the brand for the product. Able to be used for filtering. For data holders with single brands this value is still required",
        required = true
    )
    String brand;

    @Property(
        description = "An optional display name of the brand"
    )
    String brandName;

    @Property(
        description = "A link to an application web page where this product can be applied for."
    )
    @CDSDataType(CustomDataType.URI)
    String applicationUri;

    @Property(
        description = "Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable",
        required = true
    )
    @CDSDataType(CustomDataType.Boolean)
    Boolean isTailored;

    @Property
    BankingProductV2AdditionalInformation additionalInformation;

    @Property(
        description = "An array of card art images"
    )
    List<BankingProductV2CardArt> cardArt;
}
