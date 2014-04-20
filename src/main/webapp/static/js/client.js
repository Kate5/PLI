var LANGUAGES = ["JAVA", "DOT_NET", "PHP", "CPP", "PYTHON", "RUBY", "IOS", "ANDROID", "FRONT_END"];

function loadJavaIndex() {
    LANGUAGES.forEach(function (_l) {
        $.ajax({
            url: 'http://localhost:8080/api/index/' + _l,
            type: 'GET',
            success: function (data) {
                var chartData = [];

                data.forEach(function (f) {
                    chartData.push({
                        date: f.date,
                        visits: f.value
                    });
                });

                AmCharts.makeChart("chartdiv_" + _l, {
                    "type": "serial",
                    "theme": "light",
                    "pathToImages": "/static/js/amcharts/images/",
                    "dataProvider": chartData,
                    "valueAxes": [
                        {
                            "axisAlpha": 0.2,
                            "dashLength": 4,
                            "position": "left",
                            "minorGridEnabled": true
                        }
                    ],
                    "graphs": [
                        {
                            "id": "g1",
                            "balloonText": "[[category]]<br /><b><span style='font-size:14px;'>value: [[value]]</span></b>",
                            "bullet": "round",
                            "bulletBorderAlpha": 1,
                            "bulletColor": "#FFFFFF",
                            "hideBulletsCount": 50,
                            "title": "red line",
                            "valueField": "visits",
                            "useLineColorForBulletBorder": true
                        }
                    ],
                    "chartCursor": {
                        "cursorPosition": "mouse"
                    },
                    "categoryField": "date",
                    "categoryAxis": {
                        "parseDates": true,
                        "minorGridEnabled": true
                    }
                });
            }
        });
    });
}

$(document).ready(function () {
    loadJavaIndex();
});