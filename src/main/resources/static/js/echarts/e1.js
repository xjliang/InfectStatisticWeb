// 每日增长比较
function byEveryDay() {
  let start = $.trim($("#startDate").val());
  let end = $.trim($("#endDate").val());
  let province = $("[name='checkProv']:checked");
  if (province.length <= 0) {
    xtip.msg('最少选一个省份', {icon: 'e', times: 3, type: 'w'});
    return false;
  }
  let arg = {startDateStr: start, endDateStr: end, dateFormat: "yyyy-MM-dd"};
  let list = selectByTimeRange(arg);
  if (list != null) {
    let i;
    let newSuspectNum = [];
    let newConfirmNum = [];
    let newDeadNum = [];
    let totalSuspectNum = [];
    let totalConfirmNum = [];
    let totalDeadNum = [];
    let provinceTemp = [];
    for (i = 0; i < province.length; i++) {
      provinceTemp.push(province.eq(i).val());
    }
    let dateTemp = getDayBetween(start, end);
    for (i = 0; i < dateTemp.length; i++) {
      newSuspectNum[dateTemp[i]] = new Array(province.length);
      newConfirmNum[dateTemp[i]] = new Array(province.length);
      newDeadNum[dateTemp[i]] = new Array(province.length);
      totalSuspectNum[dateTemp[i]] = new Array(province.length);
      totalConfirmNum[dateTemp[i]] = new Array(province.length);
      totalDeadNum[dateTemp[i]] = new Array(province.length);
    }

    //dataFormatter(obj,provinceTemp,dateTemp);

    for (i = 0; i < list.length; i++) {
      //var provinceCode = list[i].provinceCode;
      let provinceName = list[i].provinceName;
      let nowSize = provinceTemp.indexOf(provinceName);
      if (nowSize !== -1) { //1.如果在我选择的省份里
        newSuspectNum = returnDataList(nowSize,
            list[i].updateDate.substring(0, 10),
            provinceName, list[i].newSuspectNum, newSuspectNum);
        newConfirmNum = returnDataList(nowSize,
            list[i].updateDate.substring(0, 10),
            provinceName, list[i].newConfirmNum, newConfirmNum);
        newDeadNum = returnDataList(nowSize,
            list[i].updateDate.substring(0, 10),
            provinceName, list[i].newDeadNum, newDeadNum);
        totalSuspectNum = returnDataList(nowSize,
            list[i].updateDate.substring(0, 10),
            provinceName, list[i].totalSuspectNum, totalSuspectNum);
        totalConfirmNum = returnDataList(nowSize,
            list[i].updateDate.substring(0, 10),
            provinceName, list[i].totalConfirmNum, totalConfirmNum);
        totalDeadNum = returnDataList(nowSize,
            list[i].updateDate.substring(0, 10),
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

function returnDataList(nowSize, updateDate, provinceName, listidata,
    newTotal) {
  let max = 0;
  let sum = 0;
  let size = nowSize;
  max = Math.max(max, listidata);
  sum += listidata;
  newTotal[updateDate][size] = {
    name: provinceName,
    value: listidata
  };
  newTotal[updateDate + 'max'] = Math.floor(max / 100) * 100;
  newTotal[updateDate + 'sum'] = sum;
  return newTotal;
}

function e1(dateTemp, provinceTemp, dataMap) {
  let i;
  clearChartFunc();
  var optionsArr = [];

  var formatter = '{c}';
  if ($("#showTSWZ").prop('checked')) { //是否显示提示文字
    formatter = '{a}  {c}';
  }
  var seriesTypeData = [];
  for (i = 0; i < legendData.length; i++) {
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

  for (i = 0; i < dateTemp.length; i++) {
    let title = dateTemp[i] + "新型肺炎情况";
    let sums = dateTemp[i] + "sum";
    let seriesData = [
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
  let readSpeech = $.trim($("#readSpeech").val());
  readSpeech = readSpeech * 1000;
  let optionE1 = {
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
