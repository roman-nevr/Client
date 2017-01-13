package ru.rubicon.client.model.odata.odinesnik;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 12.01.2017.
 */

public class Contract {
    @SerializedName("Ref_Key")
    private String refKey;
    @SerializedName("LineNumber")
    private String lineNumber;
    @SerializedName("Договор")
    private String contractName;

    public Contract(String refKey, String lineNumber, String contractName) {
        this.refKey = refKey;
        this.lineNumber = lineNumber;
        this.contractName = contractName;
    }

    public String getRefKey() {
        return refKey;
    }

    public void setRefKey(String refKey) {
        this.refKey = refKey;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
}
/*
{
"Ref_Key": "2217d0a7-8922-11e4-82e0-d43d7eed38ac",
"LineNumber": "1",
"Договор": "тест1"
}
 */

/*
<?xml version="1.0" encoding="UTF-8"?><entry xmlns="http://www.w3.org/2005/Atom"
		xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices"
		xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata"
		xml:base="http://77.37.142.90/post/odata/standard.odata/">
	<id>http://77.37.142.90/post/odata/standard.odata/Catalog_Контрагенты(guid'dd4e2f36-d89a-11e6-8343-40167e2531c3')</id>
	<category term="StandardODATA.Catalog_Контрагенты"
			scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme"/>
	<title type="text"/>
	<updated>2017-01-12T10:43:54</updated>
	<author/>
	<summary/>
	<link rel="http://schemas.microsoft.com/ado/2007/08/dataservices/related/Город"
			href="Catalog_Контрагенты(guid'dd4e2f36-d89a-11e6-8343-40167e2531c3')/Город"
			type="application/atom+xml;type=entry;charset=utf-8"
			title="Город"/>
	<link rel="edit"
			href="Catalog_Контрагенты(guid'dd4e2f36-d89a-11e6-8343-40167e2531c3')"
			title="edit-link"/>
	<content type="application/xml"><m:properties xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices" xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata">
	<d:Predefined>false</d:Predefined>
	<d:DataVersion>AAAAAAAETaY=</d:DataVersion>
	<d:Ref_Key>dd4e2f36-d89a-11e6-8343-40167e2531c3</d:Ref_Key>
	<d:Description>Чебоксарец</d:Description>
	<d:Code>ууууууу67</d:Code>
	<d:Дата>0001-01-01T00:00:00</d:Дата>
	<d:DeletionMark>false</d:DeletionMark>
	<d:PredefinedDataName/>
	<d:Комментарии m:type="Collection(StandardODATA.Catalog_Контрагенты_Комментарии_RowType)">
		<d:element m:type="StandardODATA.Catalog_Контрагенты_Комментарии_RowType">
			<d:LineNumber>1</d:LineNumber>
			<d:Комментарий>комментарий1</d:Комментарий>
		</d:element>
	</d:Комментарии>
	<d:Строка/>
	<d:Город_Key>c0e3d8bc-d89a-11e6-8343-40167e2531c3</d:Город_Key>
	<d:Булево>false</d:Булево>
	<d:Комментарий>коммент</d:Комментарий>
	<d:Договоры m:type="Collection(StandardODATA.Catalog_Контрагенты_Договоры_RowType)"/>
</m:properties>
	</content>
</entry>
 */
/*
<?xml version="1.0" encoding="UTF-8"?><entry xmlns="http://www.w3.org/2005/Atom"
		xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices"
		xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata"
		xml:base="http://77.37.142.90/post/odata/standard.odata/">
	<id>http://77.37.142.90/post/odata/standard.odata/Catalog_Контрагенты(guid'1fa1a135-d89b-11e6-8343-40167e2531c3')</id>
	<category term="StandardODATA.Catalog_Контрагенты"
			scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme"/>
	<title type="text"/>
	<updated>2017-01-12T10:45:45</updated>
	<author/>
	<summary/>
	<link rel="http://schemas.microsoft.com/ado/2007/08/dataservices/related/Город"
			href="Catalog_Контрагенты(guid'1fa1a135-d89b-11e6-8343-40167e2531c3')/Город"
			type="application/atom+xml;type=entry;charset=utf-8"
			title="Город"/>
	<link rel="edit"
			href="Catalog_Контрагенты(guid'1fa1a135-d89b-11e6-8343-40167e2531c3')"
			title="edit-link"/>
	<content type="application/xml"><m:properties xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices" xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata">
	<d:DeletionMark>false</d:DeletionMark>
	<d:DataVersion>AAAAAAAETag=</d:DataVersion>
	<d:Code>0000021</d:Code>
	<d:Булево>false</d:Булево>
	<d:Комментарий>коммент</d:Комментарий>
	<d:Description>Чебоксарец</d:Description>
	<d:Город_Key>c0e3d8bc-d89a-11e6-8343-40167e2531c3</d:Город_Key>
	<d:Дата>0001-01-01T00:00:00</d:Дата>
	<d:Ref_Key>1fa1a135-d89b-11e6-8343-40167e2531c3</d:Ref_Key>
	<d:PredefinedDataName/>
	<d:Predefined>false</d:Predefined>
	<d:Строка/>
	<d:Договоры m:type="Collection(StandardODATA.Catalog_Контрагенты_Договоры_RowType)"/>
	<d:Комментарии m:type="Collection(StandardODATA.Catalog_Контрагенты_Комментарии_RowType)">
		<d:element m:type="StandardODATA.Catalog_Контрагенты_Комментарии_RowType">
			<d:LineNumber>1</d:LineNumber>
			<d:Комментарий>комментарий1</d:Комментарий>
		</d:element>
	</d:Комментарии>
</m:properties>
	</content>
</entry>
 */