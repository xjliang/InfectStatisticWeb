// 各省走势图
function byEveryProvince() {
  let start = $.trim($("#startDate").val());
  let end = $.trim($("#endDate").val());
  let province = $("[name='checkProv']:checked");
  if (province.length !== 1) {
    xtip.msg('选择且只能选择一个省份', {icon: 'e', times: 3, type: 'w'});
    return false;
  }
  let arg = {start: start, end: end};
  let list = selectByObject(arg);
  if (list != null) {
    let i;
    var newSuspectNum = new Array();
    var newConfirmNum = new Array();
    var newDeadNum = new Array();
    var totalSuspectNum = new Array();
    var totalConfirmNum = new Array();
    var totalDeadNum = new Array();
    let provinceCheck = province.eq(0).val();
    let dateTemp = getDayBetween(start, end);
    for (i = 0; i < dateTemp.length; i++) {
      newSuspectNum[dateTemp[i]] = 0;
      newConfirmNum[dateTemp[i]] = 0;
      newDeadNum[dateTemp[i]] = 0;
      totalSuspectNum[dateTemp[i]] = 0;
      totalConfirmNum[dateTemp[i]] = 0;
      totalDeadNum[dateTemp[i]] = 0;
    }
    for (i = 0; i < list.length; i++) {
      const provinceName = list[i].provinceName;
      if (provinceName === provinceCheck) {
        const updateDate = list[i].updateDate.substring(0, 10);
        newSuspectNum[updateDate] = list[i].newSuspectNum;
        newConfirmNum[updateDate] = list[i].newConfirmNum;
        newDeadNum[updateDate] = list[i].newDeadNum;
        totalSuspectNum[updateDate] = list[i].totalSuspectNum;
        totalConfirmNum[updateDate] = list[i].totalConfirmNum;
        totalDeadNum[updateDate] = list[i].totalDeadNum;
      }
    }
    showHide2();
    let arg = {
      provinceCheck: provinceCheck,
      start: start,
      end: end,
      dateTemp: dateTemp,
      newSuspectNum: newSuspectNum,
      newConfirmNum: newConfirmNum,
      newDeadNum: newDeadNum,
      totalSuspectNum: totalSuspectNum,
      totalConfirmNum: totalConfirmNum,
      totalDeadNum: totalDeadNum
    };
    e2(arg);
  }
}

function updateE2Data(dateTemp, xz_lj) {
  const temp = [];
  for (let i = 0; i < dateTemp.length; i++) {
    temp.push(xz_lj[dateTemp[i]]);
  }
  return temp;
}

function updateE2SeriesData(data, name) {
  return {
    name: name,
    type: 'line',
    data: data,
    markPoint: {
      data: [
        {type: 'max', name: '最大值'},
        {type: 'min', name: '最小值'}
      ]
    },
    markLine: {
      data: [
        {type: 'average', name: '平均值'}
      ]
    }
  };
}

function e2(arg) {
  clearChartFunc();
  var title = arg.provinceCheck + "新型肺炎情况";
  //var chartDataPathText = chartDataPath+"\n"++arg.start+"至"+arg.end;
  var seriesData = [];
  seriesData.push(
      updateE2SeriesData(updateE2Data(arg.dateTemp, arg.totalSuspectNum),
          "累计疑似"));
  seriesData.push(
      updateE2SeriesData(updateE2Data(arg.dateTemp, arg.totalConfirmNum),
          "累计确诊"));
  seriesData.push(
      updateE2SeriesData(updateE2Data(arg.dateTemp, arg.totalDeadNum), "累计死亡"));
  seriesData.push(
      updateE2SeriesData(updateE2Data(arg.dateTemp, arg.newSuspectNum),
          "新增疑似"));
  seriesData.push(
      updateE2SeriesData(updateE2Data(arg.dateTemp, arg.newConfirmNum),
          "新增确诊"));
  seriesData.push(
      updateE2SeriesData(updateE2Data(arg.dateTemp, arg.newDeadNum), "新增死亡"));

  var option = {
    title: {
      text: title,
      subtext: chartDataPath
    },
    tooltip: {
      trigger: 'axis'
    },
    legend: {
      data: legendData
    },
    toolbox: {
      show: true,
      feature: {
        dataView: {show: true, readOnly: false},
        magicType: {show: true, type: ['line', 'bar']},
        restore: {show: true},
        saveAsImage: {show: true}
      }
    },
    calculable: true,
    xAxis: [
      {
        type: 'category',
        data: arg.dateTemp
      }
    ],
    yAxis: [
      {
        type: 'value'
      }
    ],
    series: seriesData
  };
  chartFunc(option);
}
