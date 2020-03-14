function firstClickByAllProvince() {
  var province = $("[name='checkProv']:checked");
  if (province.length <= 0) {
    xtip.msg('最少选一个省份', {icon: 'e', times: 3, type: 'w'});
    return false;
  }
  $("#bX").val(province.length);
  byAllProvince();
}

function byAllProvince() {
  let start = $.trim($("#startDate").val());
  let end = $.trim($("#endDate").val());
  let province = $("[name='checkProv']:checked");
  if (province.length <= 0) {
    xtip.msg('最少选一个省份', {icon: 'e', times: 3, type: 'w'});
    return false;
  }
  $("#pLength").text(province.length);
  const aX = strToInt($("#aX").val());
  const bX = strToInt($("#bX").val());
  if (aX === 0 || bX === 0 || aX > bX || bX > province.length) {
    $("#aX").val(1);
    $("#bX").val(province.length);
    xtip.msg('统计的省份范围不正确，系统自动改为1至' + province.length,
        {icon: 'e', times: 3, type: 'w'});
  }

  let arg = {startDateStr: start, endDateStr: end, dateFormat: "yyyy-MM-dd"};
  var list = selectByTimeRange(arg);
  if (list != null) {
    let i;
    var dataMap = {};
    dataMap.newSuspectNum = [];
    dataMap.newConfirmNum = [];
    dataMap.newDeadNum = [];
    dataMap.totalSuspectNum = [];
    dataMap.totalConfirmNum = [];
    dataMap.totalDeadNum = [];
    var provinceTemp = [];
    for (i = 0; i < province.length; i++) {
      provinceTemp.push(province.eq(i).val());
    }

    var dateTemp = getDayBetween(start, end);
    for (i = 0; i < dateTemp.length; i++) {
      dataMap.newSuspectNum[dateTemp[i]] = [];
      dataMap.newConfirmNum[dateTemp[i]] = [];
      dataMap.newDeadNum[dateTemp[i]] = [];
      dataMap.totalSuspectNum[dateTemp[i]] = [];
      dataMap.totalConfirmNum[dateTemp[i]] = [];
      dataMap.totalDeadNum[dateTemp[i]] = [];
    }

    const nowSort = $.trim($("[name='nowSort']:checked").val());

    //dataFormatter(obj,provinceTemp,dateTemp);

    for (i = 0; i < list.length; i++) {
      //var provinceCode = list[i].provinceCode;
      const provinceName = list[i].provinceName;
      const nowSize = provinceTemp.indexOf(provinceName);
      if (nowSize !== -1) { //1.如果在我选择的省份里
        dataMap = returnDataListByFlag(nowSort,
            list[i].updateDate.substring(0, 10),
            provinceName, list[i], dataMap);
      }
    }

    showHide3();
    e3(dateTemp, provinceTemp, dataMap);
    console.log("newSuspectNum:", dataMap);
    console.log("dateTemp:", dateTemp);
    console.log("provinceTemp:", provinceTemp);
  }
}

function returnDataListByFlag(nowSort, updateDate, provinceName, listi,
    dataMap) {
  //var nowSort = $.trim($("[name='nowSort']:checked").val());
  var size;
  var nowData;
  var listidata;
  if (nowSort === "累计疑似") {
    nowData = dataMap.totalSuspectNum[updateDate];
    listidata = listi.totalSuspectNum;
    size = dataMap.totalSuspectNum[updateDate].length;
  } else if (nowSort === "累计确诊") {
    nowData = dataMap.totalConfirmNum[updateDate];
    listidata = listi.totalConfirmNum;
    size = dataMap.totalConfirmNum[updateDate].length;
  } else if (nowSort === "累计死亡") {
    nowData = dataMap.totalDeadNum[updateDate];
    listidata = listi.totalDeadNum;
    size = dataMap.totalDeadNum[updateDate].length;
  } else if (nowSort === "新增疑似") {
    nowData = dataMap.newSuspectNum[updateDate];
    listidata = listi.newSuspectNum;
    size = dataMap.newSuspectNum[updateDate].length;
  } else if (nowSort === "新增确诊") {
    nowData = dataMap.newConfirmNum[updateDate];
    listidata = listi.newConfirmNum;
    size = dataMap.newConfirmNum[updateDate].length;
  } else if (nowSort === "新增死亡") {
    nowData = dataMap.newDeadNum[updateDate];
    listidata = listi.newDeadNum;
    size = dataMap.newDeadNum[updateDate].length;
  }

  nowData[size] = {
    name: provinceName,
    value: listidata
  };

  dataMap.totalSuspectNum[updateDate][size] = {
    name: provinceName,
    value: listi.totalSuspectNum
  };
  dataMap.totalConfirmNum[updateDate][size] = {
    name: provinceName,
    value: listi.totalConfirmNum
  };
  dataMap.totalDeadNum[updateDate][size] = {
    name: provinceName,
    value: listi.totalDeadNum
  };
  dataMap.newSuspectNum[updateDate][size] = {
    name: provinceName,
    value: listi.newSuspectNum
  };
  dataMap.newConfirmNum[updateDate][size] = {
    name: provinceName,
    value: listi.newConfirmNum
  };
  dataMap.newDeadNum[updateDate][size] = {
    name: provinceName,
    value: listi.newDeadNum
  };

  let current;
  let current1;
  let current2;
  let current3;
  let current4;
  let current5;
  let current6;
  for (var i = 0; i < nowData.length - 1; i++) {
    current = nowData[i + 1];
    current1 = dataMap.totalSuspectNum[updateDate][i + 1];
    current2 = dataMap.totalConfirmNum[updateDate][i + 1];
    current3 = dataMap.totalDeadNum[updateDate][i + 1];
    current4 = dataMap.newSuspectNum[updateDate][i + 1];
    current5 = dataMap.newConfirmNum[updateDate][i + 1];
    current6 = dataMap.newDeadNum[updateDate][i + 1];
    var preIndex = i;
    while (preIndex >= 0 && current.value < nowData[preIndex].value) {
      nowData[preIndex + 1] = nowData[preIndex];

      dataMap.totalSuspectNum[updateDate][preIndex
      + 1] = dataMap.totalSuspectNum[updateDate][preIndex];
      dataMap.totalConfirmNum[updateDate][preIndex
      + 1] = dataMap.totalConfirmNum[updateDate][preIndex];
      dataMap.totalDeadNum[updateDate][preIndex
      + 1] = dataMap.totalDeadNum[updateDate][preIndex];
      dataMap.newSuspectNum[updateDate][preIndex
      + 1] = dataMap.newSuspectNum[updateDate][preIndex];
      dataMap.newConfirmNum[updateDate][preIndex
      + 1] = dataMap.newConfirmNum[updateDate][preIndex];
      dataMap.newDeadNum[updateDate][preIndex
      + 1] = dataMap.newDeadNum[updateDate][preIndex];
      preIndex--;
    }
    nowData[preIndex + 1] = current;
    dataMap.totalSuspectNum[updateDate][preIndex + 1] = current1;
    dataMap.totalConfirmNum[updateDate][preIndex + 1] = current2;
    dataMap.totalDeadNum[updateDate][preIndex + 1] = current3;
    dataMap.newSuspectNum[updateDate][preIndex + 1] = current4;
    dataMap.newConfirmNum[updateDate][preIndex + 1] = current5;
    dataMap.newDeadNum[updateDate][preIndex + 1] = current6;
  }
  return dataMap;
}

function e3(dateTemp, provinceTemp, dataMap) {
  clearChartFunc();
  let selected = {
    '累计疑似': false, '累计确诊': false, '累计死亡': false,
    '新增疑似': false, '新增确诊': false, '新增死亡': false
  };
  let nowSort = $.trim($("[name='nowSort']:checked").val());
  selected[nowSort] = true;

  const optionsArr = [];

  let formatter = '{b} {c}';
  if ($("#showTSWZ3").prop('checked')) { //是否显示提示文字
    formatter = '{b} {a} {c}';
  }
  let seriesTypeData = [];
  for (let i = 0; i < legendData.length; i++) {
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
  if ($("#showLJPie3").prop('checked')) {
    seriesTypeData.push(
        {
          name: '占比',
          type: 'pie',
          center: ['75%', '35%'],
          radius: '28%',
          z: 100
        })
  }
  let aX = provinceTemp.length - strToInt($("#aX").val()) + 1;
  let bX = provinceTemp.length - strToInt($("#bX").val());

  for (var i = 0; i < dateTemp.length; i++) {
    var title = dateTemp[i] + "新型肺炎情况";
    var sums = dateTemp[i] + "sum";
    var seriesData = [
      {data: dataMap.totalSuspectNum[dateTemp[i]].slice(bX, aX)},
      {data: dataMap.totalConfirmNum[dateTemp[i]].slice(bX, aX)},
      {data: dataMap.totalDeadNum[dateTemp[i]].slice(bX, aX)},
      {data: dataMap.newSuspectNum[dateTemp[i]].slice(bX, aX)},
      {data: dataMap.newConfirmNum[dateTemp[i]].slice(bX, aX)},
      {data: dataMap.newDeadNum[dateTemp[i]].slice(bX, aX)},
    ];
    console.log("aXBX", dataMap.totalConfirmNum[dateTemp[i]].slice(aX, bX));
    console.log("aXOnBX", dataMap.totalConfirmNum[dateTemp[i]]);

    if ($("#showLJPie3").prop('checked')) {
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
  let optionE3 = {
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
        selected: selected
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
          // 'data':provinceTemp,
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
  chartFunc(optionE3);
}
