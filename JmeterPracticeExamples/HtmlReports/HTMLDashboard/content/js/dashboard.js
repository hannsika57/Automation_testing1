/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 96.0, "KoPercent": 4.0};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.84, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.0, 500, 1500, ""], "isController": false}, {"data": [1.0, 500, 1500, "Charts-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Security-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Register-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Reptiles-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Birds-HTTP Request"], "isController": false}, {"data": [0.5, 500, 1500, "Reserve -HTTP Request"], "isController": false}, {"data": [0.5, 500, 1500, "Bolg-TTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Sponsors -HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Courses-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Currency-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Practice Test table-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Purchase-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Cats-HTTP Request"], "isController": false}, {"data": [0.5, 500, 1500, "JMeterDownload-HTTP Request"], "isController": false}, {"data": [0.5, 500, 1500, "Tutorials-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Vacation-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Source Repositories-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Dictionary-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Changes History-HTTP Request"], "isController": false}, {"data": [0.5, 500, 1500, "Fish-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Contact-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Dogs-HTTP Request"], "isController": false}, {"data": [1.0, 500, 1500, "Converters-HTTP Request"], "isController": false}, {"data": [0.5, 500, 1500, "Login-HTTP Request"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 25, 1, 4.0, 383.76000000000005, 0, 1371, 272.0, 944.6000000000005, 1286.1, 1371.0, 9.31098696461825, 798.0388733705772, 1.2635300279329609], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["", 1, 1, 100.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, Infinity, Infinity, NaN], "isController": false}, {"data": ["Charts-HTTP Request", 1, 0, 0.0, 247.0, 247, 247, 247.0, 247.0, 247.0, 247.0, 4.048582995951417, 122.77407009109312, 0.5772393724696356], "isController": false}, {"data": ["Security-HTTP Request", 1, 0, 0.0, 21.0, 21, 21, 21.0, 21.0, 21.0, 21.0, 47.61904761904761, 696.7075892857142, 6.138392857142857], "isController": false}, {"data": ["Register-HTTP Request", 1, 0, 0.0, 437.0, 437, 437, 437.0, 437.0, 437.0, 437.0, 2.288329519450801, 14.172447082379863, 0.27486770594965676], "isController": false}, {"data": ["Reptiles-HTTP Request", 1, 0, 0.0, 157.0, 157, 157, 157.0, 157.0, 157.0, 157.0, 6.369426751592357, 26.510250796178344, 1.113405652866242], "isController": false}, {"data": ["Birds-HTTP Request", 1, 0, 0.0, 150.0, 150, 150, 150.0, 150.0, 150.0, 150.0, 6.666666666666667, 27.734375, 1.1458333333333335], "isController": false}, {"data": ["Reserve -HTTP Request", 1, 0, 0.0, 590.0, 590, 590, 590.0, 590.0, 590.0, 590.0, 1.694915254237288, 11.998477224576272, 0.21517478813559324], "isController": false}, {"data": ["Bolg-TTP Request", 1, 0, 0.0, 1371.0, 1371, 1371, 1371.0, 1371.0, 1371.0, 1371.0, 0.7293946024799417, 119.13920040116703, 0.09473582239241429], "isController": false}, {"data": ["Sponsors -HTTP Request", 1, 0, 0.0, 231.0, 231, 231, 231.0, 231.0, 231.0, 231.0, 4.329004329004329, 168.9960430194805, 0.5707183441558441], "isController": false}, {"data": ["Courses-HTTP Request", 1, 0, 0.0, 286.0, 286, 286, 286.0, 286.0, 286.0, 286.0, 3.4965034965034967, 548.3159418706294, 0.4643793706293707], "isController": false}, {"data": ["Currency-HTTP Request", 1, 0, 0.0, 254.0, 254, 254, 254.0, 254.0, 254.0, 254.0, 3.937007874015748, 78.16729207677166, 0.5882443405511811], "isController": false}, {"data": ["Practice Test table-HTTP Request", 1, 0, 0.0, 279.0, 279, 279, 279.0, 279.0, 279.0, 279.0, 3.5842293906810037, 488.5507672491039, 0.5180331541218638], "isController": false}, {"data": ["Purchase-HTTP Request", 1, 0, 0.0, 394.0, 394, 394, 394.0, 394.0, 394.0, 394.0, 2.5380710659898473, 16.643698445431472, 0.31478029822335024], "isController": false}, {"data": ["Cats-HTTP Request", 1, 0, 0.0, 150.0, 150, 150, 150.0, 150.0, 150.0, 150.0, 6.666666666666667, 27.708333333333336, 1.1393229166666667], "isController": false}, {"data": ["JMeterDownload-HTTP Request", 1, 0, 0.0, 596.0, 596, 596, 596.0, 596.0, 596.0, 596.0, 1.6778523489932886, 30.95834207214765, 0.22611682046979867], "isController": false}, {"data": ["Tutorials-HTTP Request", 1, 0, 0.0, 1088.0, 1088, 1088, 1088.0, 1088.0, 1088.0, 1088.0, 0.9191176470588235, 25.57103774126838, 0.12296788832720587], "isController": false}, {"data": ["Vacation-HTTP Request", 1, 0, 0.0, 415.0, 415, 415, 415.0, 415.0, 415.0, 415.0, 2.4096385542168677, 7.89015436746988, 0.30120481927710846], "isController": false}, {"data": ["Source Repositories-HTTP Request", 1, 0, 0.0, 23.0, 23, 23, 23.0, 23.0, 23.0, 23.0, 43.47826086956522, 598.5903532608696, 5.604619565217392], "isController": false}, {"data": ["Dictionary-HTTP Request", 1, 0, 0.0, 243.0, 243, 243, 243.0, 243.0, 243.0, 243.0, 4.11522633744856, 123.97119341563787, 0.606835133744856], "isController": false}, {"data": ["Changes History-HTTP Request", 1, 0, 0.0, 287.0, 287, 287, 287.0, 287.0, 287.0, 287.0, 3.484320557491289, 4462.635425740418, 0.47296929442508717], "isController": false}, {"data": ["Fish-HTTP Request", 1, 0, 0.0, 849.0, 849, 849, 849.0, 849.0, 849.0, 849.0, 1.1778563015312131, 5.302653857479387, 0.2012938015312132], "isController": false}, {"data": ["Contact-HTTP Request", 1, 0, 0.0, 272.0, 272, 272, 272.0, 272.0, 272.0, 272.0, 3.676470588235294, 503.8488051470588, 0.48828124999999994], "isController": false}, {"data": ["Dogs-HTTP Request", 1, 0, 0.0, 162.0, 162, 162, 162.0, 162.0, 162.0, 162.0, 6.172839506172839, 30.032310956790123, 1.0549286265432098], "isController": false}, {"data": ["Converters-HTTP Request", 1, 0, 0.0, 246.0, 246, 246, 246.0, 246.0, 246.0, 246.0, 4.065040650406504, 93.5594512195122, 0.5954649390243902], "isController": false}, {"data": ["Login-HTTP Request", 1, 0, 0.0, 846.0, 846, 846, 846.0, 846.0, 846.0, 846.0, 1.1820330969267139, 6.6350842198581566, 0.1385195035460993], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["Non HTTP response code: java.net.MalformedURLException/Non HTTP response message: Illegal character found in host: '/'", 1, 100.0, 4.0], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 25, 1, "Non HTTP response code: java.net.MalformedURLException/Non HTTP response message: Illegal character found in host: '/'", 1, "", "", "", "", "", "", "", ""], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": ["", 1, 1, "Non HTTP response code: java.net.MalformedURLException/Non HTTP response message: Illegal character found in host: '/'", 1, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
