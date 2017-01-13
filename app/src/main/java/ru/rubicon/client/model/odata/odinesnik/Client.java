package ru.rubicon.client.model.odata.odinesnik;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 12.01.2017.
 */

public class Client {

    public static final String NAME = "Description";
    public static final String ZERO_KEY = "00000000-0000-0000-0000-000000000000";

    @SerializedName("Ref_Key")
    private String refKey;
    @SerializedName("DeletionMark")
    private boolean deletionMark;
    @SerializedName("Город_Key")
    private String cityKey;
    @SerializedName(NAME)
    private String name;
    @SerializedName("Комментарий")
    private String comment;
    @SerializedName("Комментарии")
    private List<Comment> comments;
    @SerializedName("Договоры")
    private List<Contract> contracts;

    public Client(String refKey, String cityKey, String name, boolean deletionMark,
                  String comment, List<Comment> comments, List<Contract> contracts) {
        this.refKey = refKey;
        this.cityKey = cityKey;
        this.name = name;
        this.deletionMark = deletionMark;
        this.comment = comment;
        this.comments = comments;
        this.contracts = contracts;
    }

    public String getRefKey() {
        return refKey;
    }

    public void setRefKey(String refKey) {
        this.refKey = refKey;
    }

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeletionMark() {
        return deletionMark;
    }

    public void setDeletionMark(boolean deletionMark) {
        this.deletionMark = deletionMark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

/*http://server.odinesnik.ru/post/odata/standard.odata/Catalog_Контрагенты(guid'1fa1a135-d89b-11e6-8343-40167e2531c3')?$format=json
{
"odata.metadata": "http://server.odinesnik.ru/post/odata/standard.odata/$metadata#Catalog_Контрагенты/@Element",
"Город_Key": "c0e3d8bc-d89a-11e6-8343-40167e2531c3",
"Ref_Key": "1fa1a135-d89b-11e6-8343-40167e2531c3",
"DataVersion": "AAAAAAAETag=",
"Predefined": false,
"PredefinedDataName": "",
"Description": "Чебоксарец",
"Code": "0000021",
"DeletionMark": false,
"Комментарий": "коммент",
"Дата": "0001-01-01T00:00:00",
"Комментарии": [
{
"LineNumber": "1",
"Комментарий": "комментарий1"
}
],
"Договоры": [],
"Булево": false,
"Строка": "",
"Город@navigationLinkUrl": "Catalog_Контрагенты(guid'1fa1a135-d89b-11e6-8343-40167e2531c3')/Город"
}
 */

/*http://server.odinesnik.ru/post/odata/standard.odata/Catalog_Контрагенты(guid'1fa1a135-d89b-11e6-8343-40167e2531c3')?$format=atom
<?xml version="1.0" encoding="UTF-8"?><entry xmlns="http://www.w3.org/2005/Atom"
		xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices"
		xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata"
		xml:base="http://server.odinesnik.ru/post/odata/standard.odata/">
	<id>http://server.odinesnik.ru/post/odata/standard.odata/Catalog_Контрагенты(guid'1fa1a135-d89b-11e6-8343-40167e2531c3')</id>
	<category term="StandardODATA.Catalog_Контрагенты"
			scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme"/>
	<title type="text"/>
	<updated>2017-01-12T10:48:32</updated>
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
	<d:PredefinedDataName/>
	<d:Code>0000021</d:Code>
	<d:Predefined>false</d:Predefined>
	<d:Булево>false</d:Булево>
	<d:Дата>0001-01-01T00:00:00</d:Дата>
	<d:Строка/>
	<d:Город_Key>c0e3d8bc-d89a-11e6-8343-40167e2531c3</d:Город_Key>
	<d:Ref_Key>1fa1a135-d89b-11e6-8343-40167e2531c3</d:Ref_Key>
	<d:Комментарий>коммент</d:Комментарий>
	<d:DataVersion>AAAAAAAETag=</d:DataVersion>
	<d:Description>Чебоксарец</d:Description>
	<d:DeletionMark>false</d:DeletionMark>
	<d:Комментарии m:type="Collection(StandardODATA.Catalog_Контрагенты_Комментарии_RowType)">
		<d:element m:type="StandardODATA.Catalog_Контрагенты_Комментарии_RowType">
			<d:LineNumber>1</d:LineNumber>
			<d:Комментарий>комментарий1</d:Комментарий>
		</d:element>
	</d:Комментарии>
	<d:Договоры m:type="Collection(StandardODATA.Catalog_Контрагенты_Договоры_RowType)"/>
</m:properties>
	</content>
</entry>
 */

/*1с ответ
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