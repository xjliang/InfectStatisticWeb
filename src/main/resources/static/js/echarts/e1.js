//每日增长比较
function byEveryDay() {
  var start = $.trim($("#startDate").val());
  var end = $.trim($("#endDate").val());
  var province = $("[name='checkProv']:checked");
  if (province.length <= 0) {
    xtip.msg('最少选一个省份', {icon: 'e', times: 3, type: 'w'});
    return false;
  }
  var arg = {start: start, end: end};
  var list = selectByObject(arg);
  if (list != null) {
    var newSuspectNum = new Array();
    var newConfirmNum = new Array();
    var newDeadNum = new Array();
    var totalSuspectNum = new Array();
    var totalConfirmNum = new Array();
    var totalDeadNum = new Array();
    var provinceTemp = new Array();
    for (var i = 0; i < province.length; i++) {
      provinceTemp.push(province.eq(i).val());
    }
    var dateTemp = getDayBetween(start, end);
    for (var i = 0; i < dateTemp.length; i++) {
      newSuspectNum[dateTemp[i]] = new Array(province.length);
      newConfirmNum[dateTemp[i]] = new Array(province.length);
      newDeadNum[dateTemp[i]] = new Array(province.length);
      totalSuspectNum[dateTemp[i]] = new Array(province.length);
      totalConfirmNum[dateTemp[i]] = new Array(province.length);
      totalDeadNum[dateTemp[i]] = new Array(province.length);
    }

    //dataFormatter(obj,provinceTemp,dateTemp);

    for (var i = 0; i < list.length; i++) {
      //var provinceCode = list[i].provinceCode;
      var provinceName = list[i].provinceName;
      var nowSize = provinceTemp.indexOf(provinceName);
      if (nowSize != -1) { //1.如果在我选择的省份里
        newSuspectNum = returnDataList(nowSize, list[i].updateDate.substring(0, 10),
            provinceName, list[i].newSuspectNum, newSuspectNum);
        newConfirmNum = returnDataList(nowSize, list[i].updateDate.substring(0, 10),
            provinceName, list[i].newConfirmNum, newConfirmNum);
        newDeadNum = returnDataList(nowSize, list[i].updateDate.substring(0, 10),
            provinceName, list[i].newDeadNum, newDeadNum);
        totalSuspectNum = returnDataList(nowSize, list[i].updateDate.substring(0, 10),
            provinceName, list[i].totalSuspectNum, totalSuspectNum);
        totalConfirmNum = returnDataList(nowSize, list[i].updateDate.substring(0, 10),
            provinceName, list[i].totalConfirmNum, totalConfirmNum);
        totalDeadNum = returnDataList(nowSize, list[i].updateDate.substring(0, 10),
            provinceName, list[i].totalDeadNum, totalDeadNum);
      }
    }
    var dataMap = {};
    dataMap.newSuspectNum = newSuspectNum;
    dataMap.newConfirmNum = newConfirmNum;
    dataMap.newDeadNum = newDeadNum;
    dataMap.totalSuspectNum = totalSuspectNum;
    dataMap.totalConfirmNum = totalConfirmNum;
    dataMap.totalDeadNum = totalDeadNum;

    showHide1();
    e1(dateTemp, provinceTemp, dataMap);
    console.log("newSuspectNum:", newSuspectNum);
    console.log("dateTemp:", dateTemp);
    console.log("provinceTemp:", provinceTemp);
  }
}

function returnDataList(nowSize, updateDate, provinceName, listidata, xz_Lj) {
  var max = 0;
  var sum = 0;
  var size = nowSize;//xz_Lj[updateDate].length;
  max = Math.max(max, listidata);
  sum += listidata;
  xz_Lj[updateDate][size] = {
    name: provinceName,
    value: listidata
  };
  xz_Lj[updateDate + 'max'] = Math.floor(max / 100) * 100;
  xz_Lj[updateDate + 'sum'] = sum;
  return xz_Lj;
}

function e1(dateTemp, provinceTemp, dataMap) {
  clearChartFunc();
  var optionsArr = [];

  var formatter = '{c}';
  if ($("#showTSWZ").prop('checked')) { //是否显示提示文字
    formatter = '{a}  {c}';
  }
  var seriesTypeData = [];
  for (var i = 0; i < legendData.length; i++) {
    seriesTypeData.push(
        {
          name: legendData[i], label: {
            show: true,
            formatter: formatter,
            fontSize: 16,
            position: 'right'
          }, type: 'bar'
        }
    )
  }
  if ($("#showLJPie").prop('checked')) {
    seriesTypeData.push(
        {
          name: '占比',
          type: 'pie',
          center: ['75%', '35%'],
          radius: '28%',
          z: 100
        })
  }

  for (var i = 0; i < dateTemp.length; i++) {
    var title = dateTemp[i] + "新型肺炎情况";
    var sums = dateTemp[i] + "sum";
    var seriesData = [
      {data: dataMap.totalSuspectNum[dateTemp[i]]},
      {data: dataMap.totalConfirmNum[dateTemp[i]]},
      {data: dataMap.totalDeadNum[dateTemp[i]]},
      {data: dataMap.newSuspectNum[dateTemp[i]]},
      {data: dataMap.newConfirmNum[dateTemp[i]]},
      {data: dataMap.newDeadNum[dateTemp[i]]}
    ];

    if ($("#showLJPie").prop('checked')) {
      seriesData.push(
          {
            data: [
              {name: '累计疑似', value: dataMap.totalSuspectNum[sums]},
              {name: '累计确诊', value: dataMap.totalConfirmNum[sums]},
              {name: '累计死亡', value: dataMap.totalDeadNum[sums]}
            ]
          }
      );
    }

    optionsArr.push(
        {
          title: {text: title},
          series: seriesData
        }
    )
  }
  var readSpeech = $.trim($("#readSpeech").val());
  readSpeech = readSpeech * 1000;
  var optionE1 = {
    baseOption: {
      timeline: {
        axisType: 'category',
        // realtime: false,
        loop: false,
        autoPlay: true,
        // currentIndex: 2,
        playInterval: readSpeech,
        // controlStyle: {
        //     position: 'left'
        // },
        data: dateTemp,
        label: {}
      },
      title: {
        subtext: chartDataPath
      },
      tooltip: {},
      legend: {
        left: 'right',
        data: legendData,
        selected: {
          //'新增疑似': false, '新增确诊': false, '新增死亡': false
        }
      },
      calculable: true,
      grid: {
        top: 80,
        bottom: 100,
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow',
            label: {
              show: true,
              formatter: function (params) {
                return params.value.replace('\n', '');
              }
            }
          }
        }
      },
      yAxis: [
        {
          'type': 'category',
          'axisLabel': {'interval': 0},
          'data': provinceTemp,
          splitLine: {show: false}
        }
      ],
      xAxis: [
        {
          type: 'value',
          name: '人数（人）'
        }
      ],
      series: seriesTypeData
    },
    options: optionsArr
  };
  chartFunc(optionE1);
}

