package com.zaar.chequeinfo.data.inputData

import com.zaar.chequeinfo.model.dataModel.cheque.ChequeModel
import kotlinx.datetime.Instant
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

import org.junit.jupiter.api.Test

class JsonUnitTest {

    private val format = Json { ignoreUnknownKeys = false }
    private val jsonStringMultiCheques =
        """
            [{"_id":"6768c09ffc92c42a2fc2d029","createdAt":"2024-12-23T01:45:03+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-23T08:46:00","ecashTotalSum":1573473,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":7697,"fiscalDriveNumber":"7380440700365430","fiscalSign":4194367238,"items":[{"name":"ARCOS НОЖ Д/СТЕЙК ДЕРЕВ РУЧК 11СМ","nds":1,"paymentType":4,"price":56900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":56900},{"name":"ARCOS ВИЛКА Д/СТЕЙК ДЕРЕВ РУЧК 9СМ","nds":1,"paymentType":4,"price":67900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":67900},{"name":"ТУШКА УТЁНКА УЛЫБИНО ЗАМ ТЕРМОПАКЕТ","nds":2,"paymentType":4,"price":35900,"productType":1,"productCodeDataError":"unable to convert gtin to integer; not supported product type 1","quantity":2.926,"sum":105043},{"name":"900Г ГРЕЧКА НАЦИОНАЛЬ ЯДРИЦА","nds":2,"paymentType":4,"price":7990,"productType":1,"productCodeDataError":"not supported product type 3","quantity":12,"sum":95880},{"name":"1КГ САХАР ARO ТС2","nds":2,"paymentType":4,"price":6799,"productType":1,"productCodeDataError":"not supported product type 3","quantity":20,"sum":135980},{"name":"2КГ БУЛГУР МИСТРАЛЬ","nds":2,"paymentType":4,"price":34900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":3,"sum":104700},{"name":"400Г ГОРОШЕК ЗЕЛЕНЫЙ HEINZ НЕЖНЫЙ","nds":1,"paymentType":4,"price":8990,"productType":1,"productCodeDataError":"not supported product type 3","quantity":12,"sum":107880},{"name":"1,415Л КОРНИШОНЫ СКАТЕРТЬ-САМОБРАНКА","nds":1,"paymentType":4,"price":31600,"productType":1,"productCodeDataError":"not supported product type 3","quantity":6,"sum":189600},{"name":"100ШТХ1,8Г ЧАЙ ЗЕЛЁНЫЙ GREENFIELD FLYING DRAGON","nds":1,"paymentType":4,"price":32900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":32900},{"name":"370МЛ ЧЕРЕМША СКАТЕРТЬ-САМОБРАНКА МАРИНОВАННАЯ","nds":1,"paymentType":4,"price":21900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":12,"sum":262800},{"name":"30ШТ ЯЙЦО КУРИНОЕ СО ЯРКОЕ УТРО","nds":2,"paymentType":4,"price":38900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":38900},{"name":"30ШТ ЯЙЦО КУРИНОЕ СО ЯРКОЕ УТРО","nds":2,"paymentType":4,"price":38900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":38900},{"name":"20ШТ МЕШКИ ДЛЯ МУСОРА 60Л ARO 10МКМ","nds":1,"paymentType":4,"price":4390,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":4390},{"name":"100ШТХ2Г Чай черный Greenfield English Edition","nds":1,"paymentType":4,"price":32900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":32900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215*ttfD","productIdType":6,"sernum":"5*ttfD"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215B,<HG","productIdType":6,"sernum":"5B,<HG"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215N'Ujl","productIdType":6,"sernum":"5N'Ujl"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215Rbbl1","productIdType":6,"sernum":"5Rbbl1"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215K;MTC","productIdType":6,"sernum":"5K;MTC"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215vhadV","productIdType":6,"sernum":"5vhadV"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"01046064190146812156u3it","productIdType":6,"sernum":"56u3it"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215fCY3L","productIdType":6,"sernum":"5fCY3L"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215hOBLz","productIdType":6,"sernum":"5hOBLz"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215k1>U(","productIdType":6,"sernum":"5k1>U("},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215MZ!7i","productIdType":6,"sernum":"5MZ!7i"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215b9?0C","productIdType":6,"sernum":"5b9?0C"},"quantity":1,"sum":24900}],"kktRegId":"0003847772036186    ","nds10":74385,"nds18":125878,"operationType":1,"operator":"Нечаева Дарья Евгеньевна","prepaidSum":0,"provisionSum":0,"requestNumber":2,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":128,"taxationType":1,"appliedTaxationType":1,"totalSum":1573473,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"6768d73528f82e4355aeafb4","createdAt":"2024-12-23T03:21:25+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-23T10:04:00","ecashTotalSum":234000,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":16377,"fiscalDriveNumber":"7381440800358975","fiscalSign":1063084288,"items":[{"name":"Баранина","nds":6,"paymentType":4,"price":62500,"productType":1,"quantity":3.736,"sum":233500},{"name":"Пакет 5 руб..","nds":6,"paymentType":4,"price":500,"productType":1,"quantity":1,"sum":500}],"kktRegId":"0008309431030814    ","ndsNo":234000,"operationType":1,"operator":"Барсукова Е.","prepaidSum":0,"provisionSum":0,"requestNumber":8,"retailPlace":"Магазин \"МЯСО\"","retailPlaceAddress":"630079, г. Новосибирск, ул. Станиславского, д.24","shiftNumber":168,"taxationType":32,"appliedTaxationType":32,"totalSum":234000,"user":"ШАЛЬНОВА ЮЛИЯ ЮРЬЕВНА","userInn":"543308661255"}}},"user_data":{"title":"бур ШАЛЬНОВА ЮЛИЯ ЮРЬЕВНА"}},{"_id":"6768dc48fc92c42a2fc2d3d7","createdAt":"2024-12-23T03:43:04+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-23T10:42:00","ecashTotalSum":135450,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":26128,"fiscalDriveNumber":"7284440700411616","fiscalSign":2049463425,"items":[{"name":"** Пакет-майка b-аптека 24+14х45/15мкм","nds":1,"paymentType":4,"price":500,"productType":1,"quantity":1,"sum":500},{"name":"Марля медицинская 5 мх90 см вид-1 нестерил Нью Лайф ТУ 13.20.44-018-10715071-2022 по ГОСТ 9412-2021","nds":2,"paymentType":4,"price":26990,"productType":1,"quantity":1,"sum":26990},{"name":"Марля медицинская 5 мх90 см вид-1 нестерил Нью Лайф ТУ 13.20.44-018-10715071-2022 по ГОСТ 9412-2021","nds":2,"paymentType":4,"price":26990,"productType":1,"quantity":1,"sum":26990},{"name":"Марля медицинская 5 мх90 см вид-1 нестерил Нью Лайф ТУ 13.20.44-018-10715071-2022 по ГОСТ 9412-2021","nds":2,"paymentType":4,"price":26990,"productType":1,"quantity":2,"sum":53980},{"name":"Марля медицинская 5 мх90 см вид-1 нестерил Нью Лайф ТУ 13.20.44-018-10715071-2022 по ГОСТ 9412-2021","nds":2,"paymentType":4,"price":26990,"productType":1,"quantity":1,"sum":26990}],"kktRegId":"0001662980020189    ","nds10":12269,"nds18":83,"operationType":1,"operator":"Рылова Юлия Георгиевна","prepaidSum":0,"provisionSum":0,"requestNumber":21,"retailPlace":"54 - Новосибирская область, 630032, Новосибирск г, Горский мкр, 60","retailPlaceAddress":"54 - Новосибирская область, 630032, Новосибирск г, Горский мкр, 60","shiftNumber":185,"taxationType":1,"appliedTaxationType":1,"totalSum":135450,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"АПТЕКА\"ДВИНА\"","userInn":"5406712110  "}}},"user_data":{"title":"аптека ООО \"АПТЕКА\"ДВИНА\""}},{"_id":"67755ce35b29038898c5410b","createdAt":"2025-01-01T15:18:59+00:00","ticket":{"document":{"receipt":{"buyerPhoneOrAddress":"zaar3@yandex.ru","cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-23T14:22:00","ecashTotalSum":0,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":202882,"fiscalDriveNumber":"7380440801032408","fiscalSign":3850832801,"internetSign":1,"items":[{"name":"SnowDream Тюбинг, диаметр: 90 см","nds":1,"paymentAgentByProductType":64,"paymentType":4,"price":164200,"productType":1,"providerInn":"7713398355  ","quantity":1,"sum":164200}],"kktRegId":"0004877418021575    ","machineNumber":"KZN045228","nds18":27367,"operationType":1,"prepaidSum":164200,"provisionSum":0,"requestNumber":3834,"retailPlace":"ozon.ru","retailPlaceAddress":"109316, Москва, Волгоградский проспект, 42, к 9","sellerAddress":"ExchangeSupportMetazon@ozon.ru","shiftNumber":52,"taxationType":1,"appliedTaxationType":1,"totalSum":164200,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"ИНТЕРНЕТ РЕШЕНИЯ\"","userInn":"7704217370  "}}}},{"_id":"676a0a6b025375dfff8c9548","createdAt":"2024-12-24T01:12:11+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-24T08:11:00","ecashTotalSum":880736,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":20085,"fiscalDriveNumber":"7380440700365371","fiscalSign":410250735,"items":[{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215kevhnDagSpAK","productIdType":6,"sernum":"5kevhnDagSpAK"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215%q:L\"sFlKgfZ","productIdType":6,"sernum":"5%q:L\"sFlKgfZ"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215cdBdrSh%Z_tD","productIdType":6,"sernum":"5cdBdrSh%Z_tD"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215rg:FcUsBGrin","productIdType":6,"sernum":"5rg:FcUsBGrin"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215PbR+Hm)6kaXH","productIdType":6,"sernum":"5PbR+Hm)6kaXH"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215F%BsumdrMMBF","productIdType":6,"sernum":"5F%BsumdrMMBF"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215lehy\"j*gj6Fa","productIdType":6,"sernum":"5lehy\"j*gj6Fa"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215oIaow<'HLn6H","productIdType":6,"sernum":"5oIaow<'HLn6H"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"01050606087483582151xVCEt.n-Uuk","productIdType":6,"sernum":"51xVCEt.n-Uuk"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215sAaQYwcZKRRM","productIdType":6,"sernum":"5sAaQYwcZKRRM"},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215KtQ38:-1mW2.","productIdType":6,"sernum":"5KtQ38:-1mW2."},"quantity":1,"sum":10700},{"name":"0,449Л ЭН НАП BURN ПЕРСИК/МАНГО Б/САХАРА Ж/Б","nds":1,"paymentType":4,"price":10700,"productType":1,"productCodeData":{"gtin":5060608748358,"rawProductCode":"0105060608748358215XD)z8_StLBke","productIdType":6,"sernum":"5XD)z8_StLBke"},"quantity":1,"sum":10700},{"name":"250ШТ ТРУБОЧКИ Д/КОКТЕЙЛЯ RIOBA 24СМ 8ММ ЧЕРН ПЛАСТ В ИНД УП","nds":1,"paymentType":4,"price":20500,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":20500},{"name":"580МЛ ТОМАТЫ ЧЕРРИ СКАТЕРТЬ-САМОБРАНКА МЕДОВЫЕ С/Б","nds":1,"paymentType":4,"price":18900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":2,"sum":37800},{"name":"500X5Г САХАР БЕЛЫЙ RIOBA КРИСТАЛЛИЧЕСКИЙ ЭКСТРА","nds":2,"paymentType":4,"price":51900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":2,"sum":103800},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215*EeBVPpYXanP","productIdType":6,"sernum":"5*EeBVPpYXanP"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215N5sFXq9.hnUg","productIdType":6,"sernum":"5N5sFXq9.hnUg"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215ENFIIee.;prW","productIdType":6,"sernum":"5ENFIIee.;prW"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215aF)Z%_n'wfsL","productIdType":6,"sernum":"5aF)Z%_n'wfsL"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215wC3ngsdv2k:A","productIdType":6,"sernum":"5wC3ngsdv2k:A"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215FinBZ!Y1.X8O","productIdType":6,"sernum":"5FinBZ!Y1.X8O"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215TjiKQY(/tBfS","productIdType":6,"sernum":"5TjiKQY(/tBfS"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"01046500754279582154Fv8tJn)3?GI","productIdType":6,"sernum":"54Fv8tJn)3?GI"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215Tt)tCpAiw7Oq","productIdType":6,"sernum":"5Tt)tCpAiw7Oq"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215qN8MgUSD/lUD","productIdType":6,"sernum":"5qN8MgUSD/lUD"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215KSw*BcPLrFOg","productIdType":6,"sernum":"5KSw*BcPLrFOg"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ АПЕЛЬСИН ВИТ С Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075427958,"rawProductCode":"0104650075427958215A2Ci7N2trtLJ","productIdType":6,"sernum":"5A2Ci7N2trtLJ"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215dkOTFp\"X4gks","productIdType":6,"sernum":"5dkOTFp\"X4gks"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215&kQl*\"q,OG-5","productIdType":6,"sernum":"5&kQl*\"q,OG-5"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215'\":fg'K;G5CZ","productIdType":6,"sernum":"5'\":fg'K;G5CZ"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215kIH9w37jFFk?","productIdType":6,"sernum":"5kIH9w37jFFk?"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215dwqqwRXrL/%_","productIdType":6,"sernum":"5dwqqwRXrL/%_"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215nAaCqmWcO?mz","productIdType":6,"sernum":"5nAaCqmWcO?mz"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"01046500754297092152H/TenDq*5aD","productIdType":6,"sernum":"52H/TenDq*5aD"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215:TJtTjIk6TKy","productIdType":6,"sernum":"5:TJtTjIk6TKy"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215+\"EdU*9YMEUR","productIdType":6,"sernum":"5+\"EdU*9YMEUR"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215jZnUbAU.l'43","productIdType":6,"sernum":"5jZnUbAU.l'43"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215>JUTOhjXY3ht","productIdType":6,"sernum":"5>JUTOhjXY3ht"},"quantity":1,"sum":6890},{"name":"0,33Л ГАЗ НАП ДОБРЫЙ КОЛА БЕЗ САХАРА Ж/Б","nds":1,"paymentType":4,"price":6890,"productType":1,"productCodeData":{"gtin":4650075429709,"rawProductCode":"0104650075429709215X\"LyCDeqNfRZ","productIdType":6,"sernum":"5X\"LyCDeqNfRZ"},"quantity":1,"sum":6890},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kdXNZQqq)2lM","productIdType":6,"sernum":"5kdXNZQqq)2lM"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215keSAtALAaD2x","productIdType":6,"sernum":"5keSAtALAaD2x"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kdHLtCHGVrl=","productIdType":6,"sernum":"5kdHLtCHGVrl="},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kfGTYnK)KLlW","productIdType":6,"sernum":"5kfGTYnK)KLlW"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kdJIFb,R.tH\"","productIdType":6,"sernum":"5kdJIFb,R.tH\""},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215ke%uTtwH<\"0C","productIdType":6,"sernum":"5ke%uTtwH<\"0C"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kdxt2a\"LrFUn","productIdType":6,"sernum":"5kdxt2a\"LrFUn"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kdKVEIjq+gBe","productIdType":6,"sernum":"5kdKVEIjq+gBe"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kcYdkNiTkgaB","productIdType":6,"sernum":"5kcYdkNiTkgaB"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kdN>OnLGfDlf","productIdType":6,"sernum":"5kdN>OnLGfDlf"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kdJa5+NIq<KT","productIdType":6,"sernum":"5kdJa5+NIq<KT"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kefd5Q0o(LzI","productIdType":6,"sernum":"5kefd5Q0o(LzI"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kg\"pcLuAJnhy","productIdType":6,"sernum":"5kg\"pcLuAJnhy"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215khOd6;UU+TJt","productIdType":6,"sernum":"5khOd6;UU+TJt"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215khdbrZQ-f5N-","productIdType":6,"sernum":"5khdbrZQ-f5N-"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kfn5>p1(ZJ?D","productIdType":6,"sernum":"5kfn5>p1(ZJ?D"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215khNj*OntZKgy","productIdType":6,"sernum":"5khNj*OntZKgy"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kiWkW_ExjKqQ","productIdType":6,"sernum":"5kiWkW_ExjKqQ"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kgDF=SDUQXPg","productIdType":6,"sernum":"5kgDF=SDUQXPg"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kedZ(UPa!BGE","productIdType":6,"sernum":"5kedZ(UPa!BGE"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kgPoU7LDm03-","productIdType":6,"sernum":"5kgPoU7LDm03-"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215khO6O<VD/kAK","productIdType":6,"sernum":"5khO6O<VD/kAK"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215kh(Ppe979Bjh","productIdType":6,"sernum":"5kh(Ppe979Bjh"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215khwf7SWR<gNC","productIdType":6,"sernum":"5khwf7SWR<gNC"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215uoPbUssm)X_e","productIdType":6,"sernum":"5uoPbUssm)X_e"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215upFH0qV*BWdX","productIdType":6,"sernum":"5upFH0qV*BWdX"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215utyWLl4Vrtzt","productIdType":6,"sernum":"5utyWLl4Vrtzt"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215uqgI8Ge6Rq+o","productIdType":6,"sernum":"5uqgI8Ge6Rq+o"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215up1ZcOjUczBS","productIdType":6,"sernum":"5up1ZcOjUczBS"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215usJa=ORWzrkL","productIdType":6,"sernum":"5usJa=ORWzrkL"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215uoP,ti=pfH!Y","productIdType":6,"sernum":"5uoP,ti=pfH!Y"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215ut9OLwuHocMH","productIdType":6,"sernum":"5ut9OLwuHocMH"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215upnog*O?gX!O","productIdType":6,"sernum":"5upnog*O?gX!O"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215um8R,9/LzIVc","productIdType":6,"sernum":"5um8R,9/LzIVc"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215ukZ6YT%h?6X>","productIdType":6,"sernum":"5ukZ6YT%h?6X>"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ ЛИМОН/ЛАЙМ СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011502330,"rawProductCode":"0104610011502330215uq+;XHhU7FMf","productIdType":6,"sernum":"5uq+;XHhU7FMf"},"quantity":1,"sum":6491},{"name":"530Г ТОМАТЫ ЧЕРРИ СКАТЕРТЬ-САМОБРАНКА","nds":1,"paymentType":4,"price":18900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":3,"sum":56700},{"name":"720МЛ ПАТИССОНЫ СКАТЕРТЬ-САМОБРАНКА МАРИНОВАННЫЕ","nds":1,"paymentType":4,"price":26900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":5,"sum":134500}],"kktRegId":"0003847771064055    ","nds10":9436,"nds18":129484,"operationType":1,"operator":"Заболотная Марина Николаевна","prepaidSum":0,"provisionSum":0,"requestNumber":2,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":294,"taxationType":1,"appliedTaxationType":1,"totalSum":880736,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"676a2f9028f82e4355af130b","createdAt":"2024-12-24T03:50:40+00:00","ticket":{"document":{"receipt":{"buyerPhoneOrAddress":"none","cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-24T10:50:00","ecashTotalSum":53156,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":15441,"fiscalDriveNumber":"7281440701588795","fiscalSign":4154469339,"fnsUrl":"www.nalog.gov.ru","items":[{"name":"Кофе Монарх растворимый 1,8г/30","nds":1,"ndsSum":1416,"paymentType":4,"price":1699,"productType":1,"quantity":5,"sum":8495},{"name":" Клаб-сэндвич с ветчиной и сыром, 1 шт/170 гр/СП","nds":1,"ndsSum":2500,"paymentType":4,"price":14999,"productType":1,"quantity":1,"sum":14999},{"name":"Картофель Экспресс, вес/СП","nds":1,"ndsSum":1734,"paymentType":4,"price":42990,"productType":1,"quantity":0.242,"sum":10404},{"name":"Салат Цезарь с курицей, вес/СП","nds":1,"ndsSum":3210,"paymentType":4,"price":89990,"productType":1,"quantity":0.214,"sum":19258}],"kktRegId":"0007544025027419    ","machineNumber":"273210080823001399","nds18":8860,"operationType":1,"prepaidSum":0,"provisionSum":0,"requestNumber":38,"retailPlace":"Супермаркет \"SPAR\"","retailPlaceAddress":"630032, г. Новосибирск, мкр Горский, 64/1.","sellerAddress":"noreply@platformaofd.ru","shiftNumber":49,"taxationType":1,"appliedTaxationType":1,"totalSum":53156,"user":"ООО \"Перспектива\"","userInn":"7017361618  "}}}},{"_id":"676a50cf28f82e4355af1e39","createdAt":"2024-12-24T06:12:31+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-24T13:12:00","ecashTotalSum":701208,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":22939,"fiscalDriveNumber":"7380440700365295","fiscalSign":1241031859,"items":[{"name":"0,9Л МАСЛО ПОДСОЛНЕЧНОЕ КУПЕЧЕСКОЕ ЗОЛОТО РАФИН ДЕЗОДОР ГОСТ","nds":2,"paymentType":4,"price":10990,"productType":1,"productCodeDataError":"not supported product type 3","quantity":4,"sum":43960},{"name":"ЛИМОНЫ КНОПКА 30","nds":2,"paymentType":4,"price":16900,"productType":1,"productCodeDataError":"unable to convert gtin to integer; not supported product type 1","quantity":2.11,"sum":35659},{"name":"ТУШКА ГУСЯ С ПОТР. ПО-КАТАЙСКИ ЗАМ","nds":2,"paymentType":4,"price":70901,"productType":1,"productCodeDataError":"unable to convert gtin to integer; not supported product type 1","quantity":3.18,"sum":225465},{"name":"ТУШКА ГУСЯ С ПОТР. ПО-КАТАЙСКИ ЗАМ","nds":2,"paymentType":4,"price":70901,"productType":1,"productCodeDataError":"unable to convert gtin to integer; not supported product type 1","quantity":3.312,"sum":234824},{"name":"СУМКА Д/ПОКУПОК СИН MPRO","nds":1,"paymentType":4,"price":11900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":11900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215QNARo","productIdType":6,"sernum":"5QNARo"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215EActU","productIdType":6,"sernum":"5EActU"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215JkQOJ","productIdType":6,"sernum":"5JkQOJ"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215YITdV","productIdType":6,"sernum":"5YITdV"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215M%WZH","productIdType":6,"sernum":"5M%WZH"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215InkiV","productIdType":6,"sernum":"5InkiV"},"quantity":1,"sum":24900}],"kktRegId":"0003847792027876    ","nds10":62667,"nds18":1983,"operationType":1,"operator":"Куликова Инга Викторовна","prepaidSum":0,"provisionSum":0,"requestNumber":4,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":318,"taxationType":1,"appliedTaxationType":1,"totalSum":701208,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"676a50d4025375dfff8ca55f","createdAt":"2024-12-24T06:12:36+00:00","ticket":{"document":{"receipt":{"cashTotalSum":138330,"code":3,"creditSum":0,"dateTime":"2024-12-24T13:13:00","ecashTotalSum":0,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":22940,"fiscalDriveNumber":"7380440700365295","fiscalSign":606517631,"items":[{"name":"ПОМЕЛО С КРАСНОЙ МЯКОТЬЮ КНОПКА 512","nds":2,"paymentType":4,"price":18900,"productType":1,"productCodeDataError":"unable to convert gtin to integer; not supported product type 1","quantity":1.928,"sum":36439},{"name":"ЯБЛОКИ РЕД КНОПКА 9","nds":2,"paymentType":4,"price":16900,"productType":1,"productCodeDataError":"unable to convert gtin to integer; not supported product type 1","quantity":3.59,"sum":60671},{"name":"МАНДАРИНЫ С ЛИСТОМ КНОПКА 32","nds":2,"paymentType":4,"price":22900,"productType":1,"productCodeDataError":"unable to convert gtin to integer; not supported product type 1","quantity":1.8,"sum":41220}],"kktRegId":"0003847792027876    ","nds10":12576,"operationType":1,"operator":"Куликова Инга Викторовна","prepaidSum":0,"provisionSum":0,"requestNumber":5,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":318,"taxationType":1,"appliedTaxationType":1,"totalSum":138330,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"67755ce35b29038898c5410a","createdAt":"2025-01-01T15:18:59+00:00","ticket":{"document":{"receipt":{"buyerPhoneOrAddress":"zaar3@yandex.ru","cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-24T19:45:00","ecashTotalSum":23980,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":9754,"fiscalDriveNumber":"7384440800269882","fiscalSign":3015250150,"items":[{"name":"ВЛ САЛФ ДЕТ ГИПОАЛЕР","nds":1,"paymentType":4,"price":11990,"productType":1,"quantity":1,"sum":11990},{"name":"ВЛ САЛФ ДЕТ ГИПОАЛЕР","nds":1,"paymentType":4,"price":11990,"productType":1,"quantity":1,"sum":11990}],"kktRegId":"0000217600041142    ","nds18":3996,"operationType":1,"prepaidSum":0,"provisionSum":0,"requestNumber":282,"retailPlace":"Гипермаркет АШАН Сити","retailPlaceAddress":"630129, г.Новосибирск, ул. Kурчатова, д.1","shiftNumber":34,"taxationType":1,"appliedTaxationType":1,"totalSum":23980,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"АШАН\"","userInn":"7703270067  "}}}},{"_id":"67755ce35b29038898c54109","createdAt":"2025-01-01T15:18:59+00:00","ticket":{"document":{"receipt":{"buyerPhoneOrAddress":"zaar3@yandex.ru","cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-24T19:50:00","ecashTotalSum":100352,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":26288,"fiscalDriveNumber":"7281440701489843","fiscalSign":648372474,"items":[{"name":"Трусики Baby Go XL 16-25кг 72шт","nds":2,"ndsSum":9123,"paymentType":4,"price":100352,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":100352}],"kktRegId":"0007298015042572    ","nds10":9123,"operationType":1,"operator":"Курдюкова В.Е.","operatorInn":"110216821055","prepaidSum":0,"properties":{"propertyName":"ZAKAZ","propertyValue":"6175930728"},"provisionSum":0,"requestNumber":71,"retailPlace":"ТЦ \"Голден Парк\", Этаж № 2, Детский мир","retailPlaceAddress":"630129, Новосибирская область, г.Новосибирск, ул.Курчатова, д.1","sellerAddress":"check@detmir.RU","shiftNumber":230,"taxationType":1,"appliedTaxationType":1,"totalSum":100352,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"ДМ\"","userInn":"9729777779  "}}}},{"_id":"676cb2ab025375dfff8d5e01","createdAt":"2024-12-26T01:34:35+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-26T08:35:00","ecashTotalSum":219172,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":23338,"fiscalDriveNumber":"7380440700365295","fiscalSign":1731512343,"items":[{"name":"~5,77КГ МЯСО СВИНИНЫ ОХЛАЖДЕН ЛОПАТКА МИРАТОРГ 88%Б/РУЛЬКИ","nds":2,"paymentType":4,"price":34900,"productType":1,"productCodeDataError":"unable to convert gtin to integer; not supported product type 1","quantity":6.28,"sum":219172}],"kktRegId":"0003847792027876    ","nds10":19925,"operationType":1,"operator":"Федяева Валерия Васильевна","prepaidSum":0,"provisionSum":0,"requestNumber":27,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":326,"taxationType":1,"appliedTaxationType":1,"totalSum":219172,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"676cbf7d28f82e4355afd880","createdAt":"2024-12-26T02:29:17+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-26T09:27:00","ecashTotalSum":220000,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":38496,"fiscalDriveNumber":"7380440800799694","fiscalSign":44837143,"fnsUrl":"www.nalog.gov.ru","items":[{"name":"АИ-92-К5(СБЕР)                         ТРК 12","nds":1,"paymentType":4,"price":5250,"productType":1,"quantity":41.905,"sum":220001}],"kktRegId":"0007387329028415    ","nds18":36667,"operationType":1,"operator":"1 Романенко С.В Оператор","prepaidSum":0,"provisionSum":0,"requestNumber":135,"retailPlace":"ГРМ","retailPlaceAddress":"630132, г.Новосибирск, ул.Нарымская, 31","shiftNumber":134,"taxationType":1,"appliedTaxationType":1,"totalSum":220000,"user":"ООО \"Беркут","userInn":"5402141201  "}}},"user_data":{"title":"бензин ООО \"Беркут"}},{"_id":"676dfec6fc92c42a2fc469a7","createdAt":"2024-12-27T01:11:34+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-27T08:09:00","ecashTotalSum":716400,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":20856,"fiscalDriveNumber":"7380440700365371","fiscalSign":773524549,"items":[{"name":"1КГ САХАР ARO ТС2","nds":2,"paymentType":4,"price":6799,"productType":1,"productCodeDataError":"not supported product type 3","quantity":10,"sum":67990},{"name":"700МЛ МАЙОНЕЗ 67% Я ЛЮБЛЮ ГОТОВИТЬ КЛАССИЧ ПРОВАНСАЛЬ ДП","nds":1,"paymentType":4,"price":18900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":2,"sum":37800},{"name":"1КГ СОЛЬ ARO ЭКСТРА","nds":2,"paymentType":4,"price":3590,"productType":1,"productCodeDataError":"not supported product type 3","quantity":6,"sum":21540},{"name":"1Л УКСУС СТОЛОВЫЙ 9% ARO ПЭТ","nds":1,"paymentType":4,"price":4790,"productType":1,"productCodeDataError":"not supported product type 3","quantity":6,"sum":28740},{"name":"50М ПЕРГАМЕНТ ДЛЯ ВЫПЕЧКИ LOMBERTA 38СМ","nds":1,"paymentType":4,"price":59900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":59900},{"name":"0,9Л МАСЛО ПОДСОЛНЕЧНОЕ КУПЕЧЕСКОЕ ЗОЛОТО РАФИН ДЕЗОДОР ГОСТ","nds":2,"paymentType":4,"price":10990,"productType":1,"productCodeDataError":"not supported product type 3","quantity":12,"sum":131880},{"name":"100ШТХ1,8Г ЧАЙ ЗЕЛЁНЫЙ GREENFIELD FLYING DRAGON","nds":1,"paymentType":4,"price":29900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":29900},{"name":"100ШТ СТАКАН 200МЛ METRO PROFESSIONAL ПЛАСТИК","nds":1,"paymentType":4,"price":9990,"productType":1,"productCodeDataError":"not supported product type 3","quantity":5,"sum":49950},{"name":"100ШТХ2Г Чай черный Greenfield Kenyan Sunrise","nds":1,"paymentType":4,"price":29900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":29900},{"name":"СЛОВАР Д/З СЛОВ А5 СПИР 80Л AS","nds":1,"paymentType":4,"price":9900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":9900},{"name":"370МЛ ПЕРЕЦ ХАЛАПЕНЬО СКАТЕРТЬ-САМОБРАНКА ЗЕЛЕНЫЙ","nds":1,"paymentType":4,"price":19900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":5,"sum":99500},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215r)Cc_","productIdType":6,"sernum":"5r)Cc_"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215:TdbJ","productIdType":6,"sernum":"5:TdbJ"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215rcggE","productIdType":6,"sernum":"5rcggE"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215J?_TZ","productIdType":6,"sernum":"5J?_TZ"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215gh0Wd","productIdType":6,"sernum":"5gh0Wd"},"quantity":1,"sum":24900},{"name":"900Г СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":24900,"productType":33,"productCodeData":{"gtin":4606419014681,"rawProductCode":"0104606419014681215cmWX_","productIdType":6,"sernum":"5cmWX_"},"quantity":1,"sum":24900}],"kktRegId":"0003847771064055    ","nds10":33712,"nds18":57597,"operationType":1,"operator":"Фролова Наталья Олеговна","prepaidSum":0,"provisionSum":0,"requestNumber":1,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":310,"taxationType":1,"appliedTaxationType":1,"totalSum":716400,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"676dfef8fc92c42a2fc469ae","createdAt":"2024-12-27T01:12:24+00:00","ticket":{"document":{"receipt":{"cashTotalSum":83100,"code":3,"creditSum":0,"dateTime":"2024-12-27T08:10:00","ecashTotalSum":0,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":20857,"fiscalDriveNumber":"7380440700365371","fiscalSign":2552849773,"items":[{"name":"900Г ПРЯНИЧНЫЙ ДОМИК WEISS","nds":1,"paymentType":4,"price":79900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":79900},{"name":"20Г НАПИТОК КОФЕЙНЫЙ MACCOFFEE 3В1 РАСТВОРИМЫЙ","nds":1,"paymentType":4,"price":1600,"productType":1,"productCodeDataError":"not supported product type 3","quantity":2,"sum":3200}],"kktRegId":"0003847771064055    ","nds18":13850,"operationType":1,"operator":"Фролова Наталья Олеговна","prepaidSum":0,"provisionSum":0,"requestNumber":2,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":310,"taxationType":1,"appliedTaxationType":1,"totalSum":83100,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"676e21c3fc92c42a2fc46dd1","createdAt":"2024-12-27T03:40:51+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-27T10:40:00","ecashTotalSum":219470,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":27895,"fiscalDriveNumber":"7284440700613796","fiscalSign":1094422192,"fnsUrl":"www.nalog.gov.ru","items":[{"name":"Марля 5 м Претти Коттон x1","nds":2,"ndsSum":19845,"paymentType":4,"price":21830,"productType":1,"quantity":10,"sum":218300},{"name":"Пакет Геометрия 40х50 см x1","nds":1,"ndsSum":195,"paymentType":4,"price":1170,"productType":1,"quantity":1,"sum":1170}],"kktRegId":"0003299081033013    ","nds10":19845,"nds18":195,"operationType":1,"operator":"Мрясова Е. Г.","prepaidSum":0,"provisionSum":0,"requestNumber":11,"retailPlace":"Аптека,a-plus.ru,aptekiplus.ru","retailPlaceAddress":"630032,г.Новосибирск, мкр Горский,д.60,место № 2","shiftNumber":297,"taxationType":1,"appliedTaxationType":1,"totalSum":219470,"user":"ООО \"Архи-Мед\"","userInn":"6312053182  "}}},"user_data":{"title":"бур ООО \"Архи-Мед\""}},{"_id":"676f54b7025375dfff8e1b5c","createdAt":"2024-12-28T01:30:31+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-28T08:29:00","ecashTotalSum":79700,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":19821,"fiscalDriveNumber":"7380440700365552","fiscalSign":1018536431,"items":[{"name":"250Г КОНФЕТЫ MERCI МОЛОЧНЫЙ ШОКОЛАД АССОРТИ","nds":1,"paymentType":4,"price":29900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":2,"sum":59800},{"name":"ЗИМА НА СЕРОМ КРУЖКА 540МЛ","nds":1,"paymentType":4,"price":19900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":19900}],"kktRegId":"0003847782036945    ","nds18":13284,"operationType":1,"operator":"Мальцева Ольга Михайловна","prepaidSum":0,"provisionSum":0,"requestNumber":12,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":256,"taxationType":1,"appliedTaxationType":1,"totalSum":79700,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"676f54bf28f82e4355b094eb","createdAt":"2024-12-28T01:30:39+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-28T08:31:00","ecashTotalSum":374172,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":19822,"fiscalDriveNumber":"7380440700365552","fiscalSign":1734045585,"items":[{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S,kOVA)hlFRZ","productIdType":6,"sernum":"5S,kOVA)hlFRZ"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S+s0fLTtyMLZ","productIdType":6,"sernum":"5S+s0fLTtyMLZ"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S+X!Gnogcr./","productIdType":6,"sernum":"5S+X!Gnogcr./"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S'MVBZ08LrrQ","productIdType":6,"sernum":"5S'MVBZ08LrrQ"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S*WAHpScyHgl","productIdType":6,"sernum":"5S*WAHpScyHgl"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S,ex/ExmWnjc","productIdType":6,"sernum":"5S,ex/ExmWnjc"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S1Oos_GXG_zM","productIdType":6,"sernum":"5S1Oos_GXG_zM"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S/c'BHVvXH'F","productIdType":6,"sernum":"5S/c'BHVvXH'F"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S/cE<Fm:x<CL","productIdType":6,"sernum":"5S/cE<Fm:x<CL"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S.80*hRK5=DY","productIdType":6,"sernum":"5S.80*hRK5=DY"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S-yNMEI3dRYs","productIdType":6,"sernum":"5S-yNMEI3dRYs"},"quantity":1,"sum":8790},{"name":"0,33Л ГАЗ НАП RICH КОЛА СТ","nds":1,"paymentType":4,"price":8790,"productType":1,"productCodeData":{"gtin":4610011502811,"rawProductCode":"0104610011502811215S.WId<UN4i_T","productIdType":6,"sernum":"5S.WId<UN4i_T"},"quantity":1,"sum":8790},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215Olb);QLCDjH_","productIdType":6,"sernum":"5Olb);QLCDjH_"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OllS;.MRWXi<","productIdType":6,"sernum":"5OllS;.MRWXi<"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OmMeoCAnc5\"_","productIdType":6,"sernum":"5OmMeoCAnc5\"_"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OmR&nbpocmRq","productIdType":6,"sernum":"5OmR&nbpocmRq"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OlR2j3U\"\"kdz","productIdType":6,"sernum":"5OlR2j3U\"\"kdz"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OlR_=!teD9h<","productIdType":6,"sernum":"5OlR_=!teD9h<"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215Ond-gN_RqCUV","productIdType":6,"sernum":"5Ond-gN_RqCUV"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215Oo=gjYnzGgtr","productIdType":6,"sernum":"5Oo=gjYnzGgtr"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OoWr?DQg?tKl","productIdType":6,"sernum":"5OoWr?DQg?tKl"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OnrGk)CPFc\"h","productIdType":6,"sernum":"5OnrGk)CPFc\"h"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OoJonoI(S4iq","productIdType":6,"sernum":"5OoJonoI(S4iq"},"quantity":1,"sum":6491},{"name":"0,25Л ГАЗ НАП ДОБРЫЙ КОЛА СТ","nds":1,"paymentType":4,"price":6491,"productType":1,"productCodeData":{"gtin":4610011501937,"rawProductCode":"0104610011501937215OnhsRN'UOjEj","productIdType":6,"sernum":"5OnhsRN'UOjEj"},"quantity":1,"sum":6491},{"name":"300Г МАСЛИНЫ FEDERICI БЕЗ КОСТОЧКИ","nds":1,"paymentType":4,"price":15900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":12,"sum":190800}],"kktRegId":"0003847782036945    ","nds18":62364,"operationType":1,"operator":"Мальцева Ольга Михайловна","prepaidSum":0,"provisionSum":0,"requestNumber":13,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":256,"taxationType":1,"appliedTaxationType":1,"totalSum":374172,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"67755ce35b29038898c54108","createdAt":"2025-01-01T15:18:59+00:00","ticket":{"document":{"receipt":{"buyerPhoneOrAddress":"zaar3@yandex.ru","cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-29T17:39:00","ecashTotalSum":58600,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":215785,"fiscalDriveNumber":"7380440801033258","fiscalSign":2905316734,"internetSign":1,"items":[{"name":"IKEA UPPFYLLD картофелечистка","nds":6,"paymentAgentByProductType":64,"paymentType":1,"price":29300,"productType":10,"providerInn":"7810940284  ","quantity":2,"sum":58600}],"kktRegId":"0008353045004573    ","machineNumber":"KZN075808","ndsNo":58600,"operationType":1,"prepaidSum":0,"provisionSum":0,"requestNumber":3581,"retailPlace":"ozon.ru","retailPlaceAddress":"109316, Москва, Волгоградский проспект, 42, к 9","sellerAddress":"ExchangeSupportMetazon@ozon.ru","shiftNumber":51,"taxationType":1,"appliedTaxationType":1,"totalSum":58600,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"ИНТЕРНЕТ РЕШЕНИЯ\"","userInn":"7704217370  "}}}},{"_id":"6771f59028f82e4355b0fb8e","createdAt":"2024-12-30T01:21:20+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-30T08:22:00","ecashTotalSum":171860,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":24614,"fiscalDriveNumber":"7380440700365295","fiscalSign":3299072070,"items":[{"name":"0,9Л МАСЛО ПОДСОЛНЕЧНОЕ КУПЕЧЕСКОЕ ЗОЛОТО РАФИН ДЕЗОДОР ГОСТ","nds":2,"paymentType":4,"price":10990,"productType":1,"productCodeDataError":"not supported product type 3","quantity":4,"sum":43960},{"name":"5КГ СМЕТАНА 15% METRO CHEF БЗМЖ","nds":2,"paymentType":4,"price":127900,"productType":33,"productCodeData":{"gtin":4606419014667,"rawProductCode":"0104606419014667215oglos","productIdType":6,"sernum":"5oglos"},"quantity":1,"sum":127900}],"kktRegId":"0003847792027876    ","nds10":15623,"operationType":1,"operator":"Заболотная Марина Николаевна","prepaidSum":0,"provisionSum":0,"requestNumber":26,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":349,"taxationType":1,"appliedTaxationType":1,"totalSum":171860,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"6771f5e2fc92c42a2fc53079","createdAt":"2024-12-30T01:22:42+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-30T08:23:00","ecashTotalSum":63700,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":24615,"fiscalDriveNumber":"7380440700365295","fiscalSign":1150766335,"items":[{"name":"САЛФЕТКА 35*35 М/Ф POWER SCRUB YORK","nds":1,"paymentType":4,"price":14900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":14900},{"name":"10ШТ ПАКЕТЫ ДЛЯ МУСОРА 120Л LOMBERTA 3СЛ С ЗАТЯЖКАМИ","nds":1,"paymentType":4,"price":33900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":33900},{"name":"30ШТ МЕШКИ ДЛЯ МУСОРА 35Л METRO PROFESSIONAL 23МКМ С ЗАВЯЗК","nds":1,"paymentType":4,"price":14900,"productType":1,"productCodeDataError":"not supported product type 3","quantity":1,"sum":14900}],"kktRegId":"0003847792027876    ","nds18":10616,"operationType":1,"operator":"Заболотная Марина Николаевна","prepaidSum":0,"provisionSum":0,"requestNumber":27,"retailPlace":"ТЦ 1060","retailPlaceAddress":"630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11","shiftNumber":349,"taxationType":1,"appliedTaxationType":1,"totalSum":63700,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"","userInn":"7704218694  "}}}},{"_id":"67723e95025375dfff8e8400","createdAt":"2024-12-30T06:32:53+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-30T13:28:00","ecashTotalSum":497850,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":87824,"fiscalDriveNumber":"9960440302079311","fiscalSign":2980289869,"items":[{"name":"МАХРОВОЕ ПОЛОТЕНЦЕ УЗБ ЛМ 100Х150 КОР","nds":1,"paymentType":4,"price":102200,"productType":33,"productCodeData":{"gtin":4690479247042,"rawProductCode":"0104690479247042215\"!pDNcZ\"+kdE","productIdType":6,"sernum":"5\"!pDNcZ\"+kdE"},"quantity":1,"sum":102200},{"name":"МАХРОВОЕ ПОЛОТЕНЦЕ УЗБ ЛМ 100Х150 КОР","nds":1,"paymentType":4,"price":102200,"productType":33,"productCodeData":{"gtin":4690479247042,"rawProductCode":"0104690479247042215\"hwgFYdLKV!e","productIdType":6,"sernum":"5\"hwgFYdLKV!e"},"quantity":1,"sum":102200},{"name":"Пакет большой","nds":1,"paymentType":4,"price":650,"productType":1,"quantity":1,"sum":650},{"name":"САЛФЕТКА МИКРОФИБРА, 30/30 СМ, 4 ШТ","nds":1,"paymentType":4,"price":16000,"productType":1,"quantity":1,"sum":16000},{"name":"СОЛЬ ДЛЯ БАНИ С МАСЛОМ ЭВКАЛИПТА","nds":1,"paymentType":4,"price":18500,"productType":1,"quantity":1,"sum":18500},{"name":"СОЛЬ ДЛЯ БАНИ С МАСЛОМ АПЕЛЬСИНА","nds":1,"paymentType":4,"price":17000,"productType":1,"quantity":1,"sum":17000},{"name":"СОЛЬ ДЛЯ БАНИ С МАСЛОМ ЛАВАНДЫ","nds":1,"paymentType":4,"price":18500,"productType":1,"quantity":1,"sum":18500},{"name":"СОЛЬ ДЛЯ БАНИ С МАСЛОМ КЕДРА","nds":1,"paymentType":4,"price":16500,"productType":1,"quantity":1,"sum":16500},{"name":"БРИКЕТ ГИМАЛАЙСКАЯ СОЛЬ Д/БАНИ 1,2КГ","nds":1,"paymentType":4,"price":39500,"productType":1,"quantity":1,"sum":39500},{"name":"НАБ. СВЕРЛ 19ШТ DEXTER PRO","nds":1,"paymentType":4,"price":134000,"productType":1,"quantity":1,"sum":134000},{"name":"ПОДВЕС ДЛЯ РАСТЕНИЙ, 10ШТ.","nds":1,"paymentType":4,"price":16400,"productType":1,"quantity":2,"sum":32800}],"kktRegId":"0006489750029885    ","nds18":82973,"operationType":1,"operator":"Касса самообслуживания","prepaidSum":0,"provisionSum":0,"requestNumber":54,"retailPlace":"630007, Новосибирская область, г. Новосибирск, пер. Фабричный, д. 11","retailPlaceAddress":"630007, Новосибирская область, г. Новосибирск, пер. Фабричный, д. 11","shiftNumber":358,"taxationType":1,"appliedTaxationType":1,"totalSum":497850,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"ЛЕ МОНЛИД\"","userInn":"5029069967  "}}}},{"_id":"67723ead28f82e4355b0feff","createdAt":"2024-12-30T06:33:17+00:00","ticket":{"document":{"receipt":{"cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-30T13:30:00","ecashTotalSum":126400,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":87825,"fiscalDriveNumber":"9960440302079311","fiscalSign":1978873655,"items":[{"name":"Пакет малый","nds":1,"paymentType":4,"price":400,"productType":1,"quantity":1,"sum":400},{"name":"ЩЕТКА ПРОВОЛОЧ 240ММ ПЛАСТ РУЧ TOPEX","nds":1,"paymentType":4,"price":14000,"productType":1,"quantity":9,"sum":126000}],"kktRegId":"0006489750029885    ","nds18":21067,"operationType":1,"operator":"Касса самообслуживания","prepaidSum":0,"provisionSum":0,"requestNumber":55,"retailPlace":"630007, Новосибирская область, г. Новосибирск, пер. Фабричный, д. 11","retailPlaceAddress":"630007, Новосибирская область, г. Новосибирск, пер. Фабричный, д. 11","shiftNumber":358,"taxationType":1,"appliedTaxationType":1,"totalSum":126400,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"ЛЕ МОНЛИД\"","userInn":"5029069967  "}}},"user_data":{"title":"бур ООО \"ЛЕ МОНЛИД\""}},{"_id":"67755ce25b29038898c54106","createdAt":"2025-01-01T15:18:58+00:00","ticket":{"document":{"receipt":{"buyerPhoneOrAddress":"zaar3@yandex.ru","cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-30T14:30:00","ecashTotalSum":0,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":150295,"fiscalDriveNumber":"7380440801359412","fiscalSign":3247080547,"internetSign":1,"items":[{"name":"Кабель DisplayPort v1.4 3 метра GCR для PS3 PS4 X-Box 360 Blue-Ray 8K 60Hz 4K 32 Гбит/с ферритовые кольца черный","nds":1,"paymentAgentByProductType":64,"paymentType":4,"price":152700,"productType":1,"providerInn":"7814674347  ","quantity":1,"sum":152700}],"kktRegId":"0006820077011522    ","machineNumber":"KZN044419","nds18":25450,"operationType":1,"prepaidSum":152700,"provisionSum":0,"requestNumber":847,"retailPlace":"ozon.ru","retailPlaceAddress":"109316, Москва, Волгоградский проспект, 42, к 9","sellerAddress":"ExchangeSupportMetazon@ozon.ru","shiftNumber":36,"taxationType":1,"appliedTaxationType":1,"totalSum":152700,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"ИНТЕРНЕТ РЕШЕНИЯ\"","userInn":"7704217370  "}}}},{"_id":"67755ce35b29038898c54107","createdAt":"2025-01-01T15:18:59+00:00","ticket":{"document":{"receipt":{"buyerPhoneOrAddress":"zaar3@yandex.ru","cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-30T14:30:00","ecashTotalSum":0,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":48092,"fiscalDriveNumber":"7380440801352087","fiscalSign":2391330529,"internetSign":1,"items":[{"name":"IKEA UPPFYLLD картофелечистка","nds":6,"paymentAgentByProductType":64,"paymentType":4,"price":29300,"productType":1,"providerInn":"7810940284  ","quantity":2,"sum":58600}],"kktRegId":"0006195335016466    ","machineNumber":"KZN066320","ndsNo":58600,"operationType":1,"prepaidSum":58600,"provisionSum":0,"requestNumber":4992,"retailPlace":"ozon.ru","retailPlaceAddress":"109316, Москва, Волгоградский проспект, 42, к 9","sellerAddress":"ExchangeSupportMetazon@ozon.ru","shiftNumber":9,"taxationType":1,"appliedTaxationType":1,"totalSum":58600,"user":"ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"ИНТЕРНЕТ РЕШЕНИЯ\"","userInn":"7704217370  "}}}},{"_id":"6772693228f82e4355b1058a","createdAt":"2024-12-30T09:34:42+00:00","ticket":{"document":{"receipt":{"buyerPhoneOrAddress":"zaar3@yandex.ru","cashTotalSum":0,"code":3,"creditSum":0,"dateTime":"2024-12-30T16:30:00","ecashTotalSum":242536,"fiscalDocumentFormatVer":4,"fiscalDocumentNumber":85900,"fiscalDriveNumber":"7380440700231076","fiscalSign":2317868422,"fnsUrl":"www.nalog.gov.ru","items":[{"name":"Молоко ТОМСК МОЛпаст. пит 2,5% п/б1400г","nds":2,"ndsSum":1091,"paymentType":4,"price":11999,"productType":33,"productCodeData":{"gtin":4620772262206,"rawProductCode":"0104620772262206215kojpd","productIdType":6,"sernum":"5kojpd"},"quantity":1,"sum":11999},{"name":"Пакет ЛЕНТА с ручками, с рисунком 15кг","nds":1,"ndsSum":217,"paymentType":4,"price":1299,"productType":1,"quantity":1,"sum":1299},{"name":"Нап вин верм CINZANO Бьянко бел сл Ит 1L","nds":1,"ndsSum":21667,"paymentType":4,"price":129999,"productType":2,"quantity":1,"sum":129999},{"name":"Вареники ЦЕЗАРЬ с карт и жар лук 600г","nds":1,"ndsSum":2083,"paymentType":4,"price":12499,"productType":1,"quantity":1,"sum":12499},{"name":"Сметана ВЫБОР СЕМЬИ 10% стакан 200г","nds":2,"ndsSum":454,"paymentType":4,"price":4999,"productType":33,"productCodeData":{"gtin":4606068691899,"rawProductCode":"0104606068691899215Al:RN","productIdType":6,"sernum":"5Al:RN"},"quantity":1,"sum":4999},{"name":"Пиво б/а св SCHLOSSKELLER 0,5% ст 0.45L","nds":1,"ndsSum":3999,"paymentType":4,"price":3999,"productType":1,"quantity":6,"sum":23994},{"name":"Нап SANTO STEFANO кр. п/сл. пивн 0.75L","nds":1,"ndsSum":5000,"paymentType":4,"price":29999,"productType":31,"productCodeData":{"gtin":4670025475198,"rawProductCode":"0104670025475198215P2Cg7-","productIdType":6,"sernum":"5P2Cg7-"},"quantity":1,"sum":29999},{"name":"З/щетка PRESIDENT White","nds":1,"ndsSum":4500,"paymentType":4,"price":26999,"productType":1,"quantity":1,"sum":26999},{"name":"Пакет ЛЕНТА 9кг","nds":1,"ndsSum":125,"paymentType":4,"price":749,"productType":1,"quantity":1,"sum":749}],"kktRegId":"0002644990013213    ","machineNumber":"13-54233982","nds10":1545,"nds18":37591,"operationType":1,"prepaidSum":0,"properties":{"propertyName":"касса №","propertyValue":"17"},"provisionSum":0,"requestNumber":162,"retailPlace":"ТК Лента-95","retailPlaceAddress":"Россия, 630084, Новосибирская обл., г. Новосибирск, ул. Мясникова, д. 29","sellerAddress":"noreply@taxcom.ru","shiftNumber":286,"taxationType":1,"appliedTaxationType":1,"totalSum":242536,"user":"ООО \"Лента\"","userInn":"7814148471  "}}}}]
        """.trimIndent()
    private val jsonStringOnceCheque =
        """{
              "_id" : "678079b7fc92c42a2fc682dc",
              "createdAt" : "2025-01-10T01:36:55+00:00",
              "ticket" : {
                "document" : {
                  "receipt" : {
                    "cashTotalSum" : 0,
                    "code" : 3,
                    "creditSum" : 0,
                    "dateTime" : "2025-01-10T08:38:00",
                    "ecashTotalSum" : 1162497,
                    "fiscalDocumentFormatVer" : 4,
                    "fiscalDocumentNumber" : 27014,
                    "fiscalDriveNumber" : "7380440700365295",
                    "fiscalSign" : 4209675217,
                    "items" : [ {
                      "name" : "1КГ СОЛЬ ARO ЭКСТРА",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 3590,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 7,
                      "sum" : 25130
                    }, {
                      "name" : "1КГ ГОРЧИЦА CHATEL ДИЖОНСКАЯ",
                      "nds" : 1,
                      "paymentType" : 4,
                      "price" : 57900,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 1,
                      "sum" : 57900
                    }, {
                      "name" : "ЛОЖКА КУХОННАЯ 34СМ ESTILO ATTRIBUTE",
                      "nds" : 1,
                      "paymentType" : 4,
                      "price" : 19900,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 1,
                      "sum" : 19900
                    }, {
                      "name" : "800Г КРУПА ГРЕЧНЕВАЯ MAKFA ЯДРИЦА БЫСТРОРАЗВАР",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 7990,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 6,
                      "sum" : 47940
                    }, {
                      "name" : "ATTRIBUTE SPICE WOOD МЕЛЬНИЦА ДЛЯ СПЕЦИЙ В13СМ",
                      "nds" : 1,
                      "paymentType" : 4,
                      "price" : 44900,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 1,
                      "sum" : 44900
                    }, {
                      "name" : "50М ПЕРГАМЕНТ ДЛЯ ВЫПЕЧКИ LOMBERTA 38СМ",
                      "nds" : 1,
                      "paymentType" : 4,
                      "price" : 59900,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 1,
                      "sum" : 59900
                    }, {
                      "name" : "800Г ПРИПРАВА METRO CHEF ДЛЯ КУРИЦЫ",
                      "nds" : 1,
                      "paymentType" : 4,
                      "price" : 41900,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 8,
                      "sum" : 335200
                    }, {
                      "name" : "1КГ СОЛЬ МОРСКАЯ 4LIFE КРУПНАЯ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 11000,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 1,
                      "sum" : 11000
                    }, {
                      "name" : "ЛИМОНЫ КНОПКА 30",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 16900,
                      "productType" : 1,
                      "productCodeDataError" : "unable to convert gtin to integer; not supported product type 1",
                      "quantity" : 1.23,
                      "sum" : 20787
                    }, {
                      "name" : "100ШТ САЛФЕТКИ БУМАЖ ARO 24Х24 1СЛ БЕЛЫЙ",
                      "nds" : 1,
                      "paymentType" : 4,
                      "price" : 2490,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 16,
                      "sum" : 39840
                    }, {
                      "name" : "ТЕТРАДЬ СПИР КЛ 96Л AS",
                      "nds" : 1,
                      "paymentType" : 4,
                      "price" : 9900,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 1,
                      "sum" : 9900
                    }, {
                      "name" : "30ШТ ЯЙЦО КУРИНОЕ СО ЯРКОЕ УТРО",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 41900,
                      "productType" : 1,
                      "productCodeDataError" : "not supported product type 3",
                      "quantity" : 1,
                      "sum" : 41900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "01046064190146812156;JI:",
                        "productIdType" : 6,
                        "sernum" : "56;JI:"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215_B)Xo",
                        "productIdType" : 6,
                        "sernum" : "5_B)Xo"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215Zrnqw",
                        "productIdType" : 6,
                        "sernum" : "5Zrnqw"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215YokXJ",
                        "productIdType" : 6,
                        "sernum" : "5YokXJ"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215bNLyn",
                        "productIdType" : 6,
                        "sernum" : "5bNLyn"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215OGLlg",
                        "productIdType" : 6,
                        "sernum" : "5OGLlg"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215qn\"QC",
                        "productIdType" : 6,
                        "sernum" : "5qn\"QC"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215'5OGK",
                        "productIdType" : 6,
                        "sernum" : "5'5OGK"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215rq;UH",
                        "productIdType" : 6,
                        "sernum" : "5rq;UH"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215cybPf",
                        "productIdType" : 6,
                        "sernum" : "5cybPf"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215PMc;Z",
                        "productIdType" : 6,
                        "sernum" : "5PMc;Z"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215Dt9.7",
                        "productIdType" : 6,
                        "sernum" : "5Dt9.7"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "01046064190146812157qls.",
                        "productIdType" : 6,
                        "sernum" : "57qls."
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215g=ccp",
                        "productIdType" : 6,
                        "sernum" : "5g=ccp"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215rk?xk",
                        "productIdType" : 6,
                        "sernum" : "5rk?xk"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215DjZ&J",
                        "productIdType" : 6,
                        "sernum" : "5DjZ&J"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "01046064190146812156f)?h",
                        "productIdType" : 6,
                        "sernum" : "56f)?h"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    }, {
                      "name" : "900Г СМЕТАНА 15% METRO CHEF БЗМЖ",
                      "nds" : 2,
                      "paymentType" : 4,
                      "price" : 24900,
                      "productType" : 33,
                      "productCodeData" : {
                        "gtin" : 4606419014681,
                        "rawProductCode" : "0104606419014681215c-ljE",
                        "productIdType" : 6,
                        "sernum" : "5c-ljE"
                      },
                      "quantity" : 1,
                      "sum" : 24900
                    } ],
                    "kktRegId" : "0003847792027876    ",
                    "nds10" : 54094,
                    "nds18" : 94590,
                    "operationType" : 1,
                    "operator" : "Черкаева Лариса Владимировна",
                    "prepaidSum" : 0,
                    "provisionSum" : 0,
                    "requestNumber" : 13,
                    "retailPlace" : "ТЦ 1060",
                    "retailPlaceAddress" : "630049, Новосибирская область, г. Новосибирск, ул. Северная, д.11",
                    "shiftNumber" : 382,
                    "taxationType" : 1,
                    "appliedTaxationType" : 1,
                    "totalSum" : 1162497,
                    "user" : "ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"МЕТРО КЭШ ЭНД КЕРРИ\"",
                    "userInn" : "7704218694  "
                  }
                }
              }
}""".trimIndent()

    @Test
    fun jsonTestOnceCheque() {
        val chequeModel = format.decodeFromString<ChequeModel>(jsonStringOnceCheque)
        chequeModel
        val strJson = format.encodeToString(chequeModel)
        strJson
    }

    @Test
    fun jsonTestMultiCheque() {
        val chequeModels = format.decodeFromString<List<ChequeModel>>(jsonStringMultiCheques)
        chequeModels
    }

    @Test
    fun jsonTestLocalDate() {
        val instant1 = Instant.parse("2025-01-08T05:07:33+00:00")
        instant1
    }
}