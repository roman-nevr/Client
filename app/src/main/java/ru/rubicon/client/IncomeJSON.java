package ru.rubicon.client;

/**
 * Created by Admin on 30.12.2016.
 */

public class IncomeJSON {
}
/*
http://moon/Test/odata/standard.odata/Document_РасходныйОрдер?$format=application/json
* {
"odata.metadata": "http://moon/Test/odata/standard.odata/$metadata#Document_ПриходныйОрдер",
"value": [{
"Ref_Key": "b1c89d94-cb6a-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAAAQAAAAA=",
"DeletionMark": false,
"Number": "000000001",
"Date": "2016-12-26T16:00:52",
"Posted": false,
"ВидОперации": "Покупка",
"Склад_Key": "3aa3cd58-c109-11e6-a7a6-5404a6b4b8ed",
"Контрагент_Key": "b1c89d93-cb6a-11e6-aede-5404a6b4b8ed",
"НомерКонтракта": "           ",
"ДатаКонтракта": "0001-01-01T00:00:00",
"Комментарий": "",
"Подразделение_Key": "b837edfd-c36d-11e6-aede-5404a6b4b8ed",
"РабочийЦентр_Key": "b837edff-c36d-11e6-aede-5404a6b4b8ed",
"Ответственный_Key": "4b990e7f-c046-11e6-9160-5404a6b4b8ed",
"ОкончаниеОприходованиеКонтракта": false,
"ДокументОснование_Key": "00000000-0000-0000-0000-000000000000",
"ПриходоватьТоварПоСериям": false,
"Товары": [
{
"Ref_Key": "b1c89d94-cb6a-11e6-aede-5404a6b4b8ed",
"LineNumber": "1",
"Номенклатура_Key": "00000000-0000-0000-0000-000000000000",
"Количество": 0,
"ЕдиницаИзмерения_Key": "00000000-0000-0000-0000-000000000000",
"Качество_Key": "00000000-0000-0000-0000-000000000000",
"ШтрихКод": "                    ",
"МестоХранения_Key": "00000000-0000-0000-0000-000000000000",
"СпособТранспортировки_Key": "00000000-0000-0000-0000-000000000000",
"ЭлементСтруктурыХранения_Key": "00000000-0000-0000-0000-000000000000",
"СерийныйНомер": "",
"Подобран": false,
"СпособПодбораМеста": "",
"Кладовщик_Key": "00000000-0000-0000-0000-000000000000"
}
],
"Излишки": [],
"Недостача": [],
"Контроль": [],
"Стеллажи": [],
"Склад@navigationLinkUrl": "Document_ПриходныйОрдер(guid'b1c89d94-cb6a-11e6-aede-5404a6b4b8ed')/Склад",
"Контрагент@navigationLinkUrl": "Document_ПриходныйОрдер(guid'b1c89d94-cb6a-11e6-aede-5404a6b4b8ed')/Контрагент",
"Подразделение@navigationLinkUrl": "Document_ПриходныйОрдер(guid'b1c89d94-cb6a-11e6-aede-5404a6b4b8ed')/Подразделение",
"РабочийЦентр@navigationLinkUrl": "Document_ПриходныйОрдер(guid'b1c89d94-cb6a-11e6-aede-5404a6b4b8ed')/РабочийЦентр",
"Ответственный@navigationLinkUrl": "Document_ПриходныйОрдер(guid'b1c89d94-cb6a-11e6-aede-5404a6b4b8ed')/Ответственный"
},{
"Ref_Key": "f8c956e5-cdad-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAAAwAAAAA=",
"DeletionMark": false,
"Number": "000000002",
"Date": "2016-12-29T13:03:29",
"Posted": false,
"ВидОперации": "РезультатИнвентаризации",
"Склад_Key": "3aa3cd58-c109-11e6-a7a6-5404a6b4b8ed",
"Контрагент_Key": "00000000-0000-0000-0000-000000000000",
"НомерКонтракта": "           ",
"ДатаКонтракта": "0001-01-01T00:00:00",
"Комментарий": "",
"Подразделение_Key": "f8c956e3-cdad-11e6-aede-5404a6b4b8ed",
"РабочийЦентр_Key": "b1c89da0-cb6a-11e6-aede-5404a6b4b8ed",
"Ответственный_Key": "f8c956e4-cdad-11e6-aede-5404a6b4b8ed",
"ОкончаниеОприходованиеКонтракта": false,
"ДокументОснование_Key": "00000000-0000-0000-0000-000000000000",
"ПриходоватьТоварПоСериям": false,
"Товары": [
{
"Ref_Key": "f8c956e5-cdad-11e6-aede-5404a6b4b8ed",
"LineNumber": "1",
"Номенклатура_Key": "68c21ae9-cd73-11e6-aede-5404a6b4b8ed",
"Количество": 2,
"ЕдиницаИзмерения_Key": "136f8719-cd75-11e6-aede-5404a6b4b8ed",
"Качество_Key": "c531161f-422a-4245-8f9a-569def45e0f4",
"ШтрихКод": "1                   ",
"МестоХранения_Key": "00000000-0000-0000-0000-000000000000",
"СпособТранспортировки_Key": "b1c89da2-cb6a-11e6-aede-5404a6b4b8ed",
"ЭлементСтруктурыХранения_Key": "00000000-0000-0000-0000-000000000000",
"СерийныйНомер": "",
"Подобран": false,
"СпособПодбораМеста": "",
"Кладовщик_Key": "f8c956e4-cdad-11e6-aede-5404a6b4b8ed"
},
{
"Ref_Key": "f8c956e5-cdad-11e6-aede-5404a6b4b8ed",
"LineNumber": "2",
"Номенклатура_Key": "68c21ae9-cd73-11e6-aede-5404a6b4b8ed",
"Количество": 2,
"ЕдиницаИзмерения_Key": "00000000-0000-0000-0000-000000000000",
"Качество_Key": "c531161f-422a-4245-8f9a-569def45e0f4",
"ШтрихКод": "1                   ",
"МестоХранения_Key": "00000000-0000-0000-0000-000000000000",
"СпособТранспортировки_Key": "b1c89da2-cb6a-11e6-aede-5404a6b4b8ed",
"ЭлементСтруктурыХранения_Key": "00000000-0000-0000-0000-000000000000",
"СерийныйНомер": "",
"Подобран": false,
"СпособПодбораМеста": "",
"Кладовщик_Key": "f8c956e4-cdad-11e6-aede-5404a6b4b8ed"
},
{
"Ref_Key": "f8c956e5-cdad-11e6-aede-5404a6b4b8ed",
"LineNumber": "3",
"Номенклатура_Key": "00000000-0000-0000-0000-000000000000",
"Количество": 0,
"ЕдиницаИзмерения_Key": "00000000-0000-0000-0000-000000000000",
"Качество_Key": "00000000-0000-0000-0000-000000000000",
"ШтрихКод": "                    ",
"МестоХранения_Key": "00000000-0000-0000-0000-000000000000",
"СпособТранспортировки_Key": "00000000-0000-0000-0000-000000000000",
"ЭлементСтруктурыХранения_Key": "00000000-0000-0000-0000-000000000000",
"СерийныйНомер": "",
"Подобран": false,
"СпособПодбораМеста": "",
"Кладовщик_Key": "00000000-0000-0000-0000-000000000000"
}
],
"Излишки": [],
"Недостача": [],
"Контроль": [],
"Стеллажи": [
{
"Ref_Key": "f8c956e5-cdad-11e6-aede-5404a6b4b8ed",
"LineNumber": "1",
"Стеллаж": 0
},
{
"Ref_Key": "f8c956e5-cdad-11e6-aede-5404a6b4b8ed",
"LineNumber": "2",
"Стеллаж": 0
}
],
"Склад@navigationLinkUrl": "Document_ПриходныйОрдер(guid'f8c956e5-cdad-11e6-aede-5404a6b4b8ed')/Склад",
"Подразделение@navigationLinkUrl": "Document_ПриходныйОрдер(guid'f8c956e5-cdad-11e6-aede-5404a6b4b8ed')/Подразделение",
"РабочийЦентр@navigationLinkUrl": "Document_ПриходныйОрдер(guid'f8c956e5-cdad-11e6-aede-5404a6b4b8ed')/РабочийЦентр",
"Ответственный@navigationLinkUrl": "Document_ПриходныйОрдер(guid'f8c956e5-cdad-11e6-aede-5404a6b4b8ed')/Ответственный"
},{
"Ref_Key": "f8c956e7-cdad-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAABQAAAAA=",
"DeletionMark": false,
"Number": "000000003",
"Date": "2016-12-29T13:10:49",
"Posted": false,
"ВидОперации": "ВводОстатков",
"Склад_Key": "b1c89d9c-cb6a-11e6-aede-5404a6b4b8ed",
"Контрагент_Key": "00000000-0000-0000-0000-000000000000",
"НомерКонтракта": "           ",
"ДатаКонтракта": "0001-01-01T00:00:00",
"Комментарий": "",
"Подразделение_Key": "b837edfd-c36d-11e6-aede-5404a6b4b8ed",
"РабочийЦентр_Key": "b837edff-c36d-11e6-aede-5404a6b4b8ed",
"Ответственный_Key": "b1c89da6-cb6a-11e6-aede-5404a6b4b8ed",
"ОкончаниеОприходованиеКонтракта": false,
"ДокументОснование_Key": "00000000-0000-0000-0000-000000000000",
"ПриходоватьТоварПоСериям": false,
"Товары": [
{
"Ref_Key": "f8c956e7-cdad-11e6-aede-5404a6b4b8ed",
"LineNumber": "1",
"Номенклатура_Key": "68c21ae9-cd73-11e6-aede-5404a6b4b8ed",
"Количество": 234,
"ЕдиницаИзмерения_Key": "201f925e-cd74-11e6-aede-5404a6b4b8ed",
"Качество_Key": "c531161f-422a-4245-8f9a-569def45e0f4",
"ШтрихКод": "                    ",
"МестоХранения_Key": "00000000-0000-0000-0000-000000000000",
"СпособТранспортировки_Key": "b1c89da1-cb6a-11e6-aede-5404a6b4b8ed",
"ЭлементСтруктурыХранения_Key": "00000000-0000-0000-0000-000000000000",
"СерийныйНомер": "",
"Подобран": false,
"СпособПодбораМеста": "",
"Кладовщик_Key": "f8c956e4-cdad-11e6-aede-5404a6b4b8ed"
}
],
"Излишки": [],
"Недостача": [],
"Контроль": [],
"Стеллажи": [],
"Склад@navigationLinkUrl": "Document_ПриходныйОрдер(guid'f8c956e7-cdad-11e6-aede-5404a6b4b8ed')/Склад",
"Подразделение@navigationLinkUrl": "Document_ПриходныйОрдер(guid'f8c956e7-cdad-11e6-aede-5404a6b4b8ed')/Подразделение",
"РабочийЦентр@navigationLinkUrl": "Document_ПриходныйОрдер(guid'f8c956e7-cdad-11e6-aede-5404a6b4b8ed')/РабочийЦентр",
"Ответственный@navigationLinkUrl": "Document_ПриходныйОрдер(guid'f8c956e7-cdad-11e6-aede-5404a6b4b8ed')/Ответственный"
},{
"Ref_Key": "8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAACAAAAAA=",
"DeletionMark": false,
"Number": "000000004",
"Date": "2016-12-29T14:37:27",
"Posted": false,
"ВидОперации": "Покупка",
"Склад_Key": "f8c956ee-cdad-11e6-aede-5404a6b4b8ed",
"Контрагент_Key": "b1c89d93-cb6a-11e6-aede-5404a6b4b8ed",
"НомерКонтракта": "00000000002",
"ДатаКонтракта": "2016-12-29T00:00:00",
"Комментарий": "к",
"Подразделение_Key": "b837edfd-c36d-11e6-aede-5404a6b4b8ed",
"РабочийЦентр_Key": "b1c89da0-cb6a-11e6-aede-5404a6b4b8ed",
"Ответственный_Key": "4b990e7f-c046-11e6-9160-5404a6b4b8ed",
"ОкончаниеОприходованиеКонтракта": false,
"ДокументОснование_Key": "8bbfc2c7-cdb9-11e6-aede-5404a6b4b8ed",
"ПриходоватьТоварПоСериям": false,
"Товары": [
{
"Ref_Key": "8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed",
"LineNumber": "1",
"Номенклатура_Key": "f8c956ea-cdad-11e6-aede-5404a6b4b8ed",
"Количество": 52,
"ЕдиницаИзмерения_Key": "f8c956eb-cdad-11e6-aede-5404a6b4b8ed",
"Качество_Key": "c531161f-422a-4245-8f9a-569def45e0f4",
"ШтрихКод": "                    ",
"МестоХранения_Key": "00000000-0000-0000-0000-000000000000",
"СпособТранспортировки_Key": "b1c89da1-cb6a-11e6-aede-5404a6b4b8ed",
"ЭлементСтруктурыХранения_Key": "00000000-0000-0000-0000-000000000000",
"СерийныйНомер": "",
"Подобран": false,
"СпособПодбораМеста": "",
"Кладовщик_Key": "b1c89da6-cb6a-11e6-aede-5404a6b4b8ed"
},
{
"Ref_Key": "8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed",
"LineNumber": "2",
"Номенклатура_Key": "68c21ae9-cd73-11e6-aede-5404a6b4b8ed",
"Количество": 1,
"ЕдиницаИзмерения_Key": "136f8719-cd75-11e6-aede-5404a6b4b8ed",
"Качество_Key": "c531161f-422a-4245-8f9a-569def45e0f4",
"ШтрихКод": "                    ",
"МестоХранения_Key": "00000000-0000-0000-0000-000000000000",
"СпособТранспортировки_Key": "b1c89da2-cb6a-11e6-aede-5404a6b4b8ed",
"ЭлементСтруктурыХранения_Key": "00000000-0000-0000-0000-000000000000",
"СерийныйНомер": "",
"Подобран": false,
"СпособПодбораМеста": "",
"Кладовщик_Key": "b837edfe-c36d-11e6-aede-5404a6b4b8ed"
}
],
"Излишки": [],
"Недостача": [],
"Контроль": [],
"Стеллажи": [
{
"Ref_Key": "8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed",
"LineNumber": "1",
"Стеллаж": 211
}
],
"Склад@navigationLinkUrl": "Document_ПриходныйОрдер(guid'8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed')/Склад",
"Контрагент@navigationLinkUrl": "Document_ПриходныйОрдер(guid'8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed')/Контрагент",
"Подразделение@navigationLinkUrl": "Document_ПриходныйОрдер(guid'8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed')/Подразделение",
"РабочийЦентр@navigationLinkUrl": "Document_ПриходныйОрдер(guid'8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed')/РабочийЦентр",
"Ответственный@navigationLinkUrl": "Document_ПриходныйОрдер(guid'8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed')/Ответственный",
"ДокументОснование@navigationLinkUrl": "Document_ПриходныйОрдер(guid'8bbfc2cc-cdb9-11e6-aede-5404a6b4b8ed')/ДокументОснование"
}]
}
* */


/*
*http://moon/Test/odata/standard.odata/Catalog_Номенклатура(guid'f8c956ea-cdad-11e6-aede-5404a6b4b8ed')?$format=application/json
* {
"odata.metadata": "http://moon/Test/odata/standard.odata/$metadata#Catalog_Номенклатура/@Element",
"Весовой": true,
"ЕдиницаИзмеренияДляСравненияОтгрузок_Key": "00000000-0000-0000-0000-000000000000",
"IsFolder": false,
"DeletionMark": false,
"СерийныйУчет": null,
"Predefined": false,
"PredefinedDataName": "",
"Ref_Key": "f8c956ea-cdad-11e6-aede-5404a6b4b8ed",
"Картинки": [],
"Description": "НеЖенскаяНеСумка",
"Артикул": "412",
"Code": "00000000005",
"DataVersion": "AAAADAAAAAA=",
"Parent_Key": "f8c956e9-cdad-11e6-aede-5404a6b4b8ed",
"Parent@navigationLinkUrl": "Catalog_Номенклатура(guid'f8c956ea-cdad-11e6-aede-5404a6b4b8ed')/Parent"
}
* */

/*
http://moon/Test/odata/standard.odata/Catalog_Номенклатура(guid'68c21ae9-cd73-11e6-aede-5404a6b4b8ed')/ЕдиницаИзмеренияДляСравненияОтгрузок?$format=application/json
{
"odata.metadata": "http://moon/Test/odata/standard.odata/$metadata#Catalog_ЕдиницыИзмерения/@Element",
"Description": "шт",
"Code": "000000001",
"PredefinedDataName": "",
"Ref_Key": "68c21aea-cd73-11e6-aede-5404a6b4b8ed",
"Predefined": false,
"Owner_Key": "68c21ae9-cd73-11e6-aede-5404a6b4b8ed",
"Коэффициент": "1",
"DeletionMark": false,
"Вес": 20,
"DataVersion": "AAAAAwAAAAA=",
"Owner@navigationLinkUrl": "Catalog_ЕдиницыИзмерения(guid'68c21aea-cd73-11e6-aede-5404a6b4b8ed')/Owner"
}
 */

/*
http://moon/Test/odata/standard.odata/Catalog_ЕдиницыИзмерения?$format=application/json
{
"odata.metadata": "http://moon/Test/odata/standard.odata/$metadata#Catalog_ЕдиницыИзмерения",
"value": [{
"Ref_Key": "68c21aea-cd73-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAAAwAAAAA=",
"DeletionMark": false,
"Owner_Key": "68c21ae9-cd73-11e6-aede-5404a6b4b8ed",
"Code": "000000001",
"Description": "шт",
"Вес": 20,
"Коэффициент": "1",
"Predefined": false,
"PredefinedDataName": "",
"Owner@navigationLinkUrl": "Catalog_ЕдиницыИзмерения(guid'68c21aea-cd73-11e6-aede-5404a6b4b8ed')/Owner"
},{
"Ref_Key": "201f925e-cd74-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAAAgAAAAA=",
"DeletionMark": false,
"Owner_Key": "68c21ae9-cd73-11e6-aede-5404a6b4b8ed",
"Code": "000000002",
"Description": "Бета",
"Вес": 10,
"Коэффициент": "10",
"Predefined": false,
"PredefinedDataName": "",
"Owner@navigationLinkUrl": "Catalog_ЕдиницыИзмерения(guid'201f925e-cd74-11e6-aede-5404a6b4b8ed')/Owner"
},{
"Ref_Key": "136f8719-cd75-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAABAAAAAA=",
"DeletionMark": false,
"Owner_Key": "68c21ae9-cd73-11e6-aede-5404a6b4b8ed",
"Code": "000000003",
"Description": "прпро",
"Вес": 10,
"Коэффициент": "5",
"Predefined": false,
"PredefinedDataName": "",
"Owner@navigationLinkUrl": "Catalog_ЕдиницыИзмерения(guid'136f8719-cd75-11e6-aede-5404a6b4b8ed')/Owner"
},{
"Ref_Key": "f8c956eb-cdad-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAABQAAAAA=",
"DeletionMark": false,
"Owner_Key": "f8c956ea-cdad-11e6-aede-5404a6b4b8ed",
"Code": "000000004",
"Description": "асу",
"Вес": 50,
"Коэффициент": "2",
"Predefined": false,
"PredefinedDataName": "",
"Owner@navigationLinkUrl": "Catalog_ЕдиницыИзмерения(guid'f8c956eb-cdad-11e6-aede-5404a6b4b8ed')/Owner"
},{
"Ref_Key": "f8c956ec-cdad-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAABgAAAAA=",
"DeletionMark": false,
"Owner_Key": "f8c956ea-cdad-11e6-aede-5404a6b4b8ed",
"Code": "000000005",
"Description": "Нога",
"Вес": 3,
"Коэффициент": "2",
"Predefined": false,
"PredefinedDataName": "",
"Owner@navigationLinkUrl": "Catalog_ЕдиницыИзмерения(guid'f8c956ec-cdad-11e6-aede-5404a6b4b8ed')/Owner"
},{
"Ref_Key": "e614152d-cdcc-11e6-aede-5404a6b4b8ed",
"DataVersion": "AAAABwAAAAA=",
"DeletionMark": false,
"Owner_Key": "f8c956ea-cdad-11e6-aede-5404a6b4b8ed",
"Code": "000000006",
"Description": "ййу32",
"Вес": 31,
"Коэффициент": "1",
"Predefined": false,
"PredefinedDataName": "",
"Owner@navigationLinkUrl": "Catalog_ЕдиницыИзмерения(guid'e614152d-cdcc-11e6-aede-5404a6b4b8ed')/Owner"
}]
}
 */