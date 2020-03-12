function showChinaMap() {
  // let start = $.trim($("#startDate").val());
  let end = $.trim($("#endDate").val());
  let arg = {startDate: end, endDate: end};
  let list = selectByObject(arg);

  let mapData = list.map(item => ({
    name: item.provinceName.substring(0, 2),
    value: item.totalConfirmNum
  }));

  showHide4();
  e4(mapData);
}

function e4(data) {
  clearChartFunc();

  const mapOption = {
    title: {
      text: "疫情统计图",
      //link: "https://www.baidu.com",
      subtext: "数据来自新浪",
      //sublink: "https://www.baidu.com"
    },
    series: [
      {
        name: "确诊人数",
        type: "map",
        map: "china",
        label: {
          show: true, // default show area name
          color: "#333", // font color of area
          fontSize: "10"
        },
        itemStyle: {
          areaColor: "#eee",
          emphasis: {
            areaColor: "#34e3ee"
          }
        },

        roam: true,
        zoom: 1.2,
        data: []
      }
    ],
    visualMap: [
      {
        type: "piecewise",
        show: true,
        splitNumber: "7",
        pieces: [
          // Range of a piece can be specified by property min and max,
          // where min will be set as -Infinity if ignored,
          // and max will be set as Infinity if ignored.
          {min: 10000, label: "10000 人及以上", color: "#DE1F05"},
          {min: 1000, max: 9999, label: "1000-9999 人", color: "#FF2736"},
          {min: 500, max: 999, label: "500-999 人", color: "#FF4361"},
          {min: 100, max: 499, label: "100-499 人", color: "#FFA577"},
          {min: 10, max: 99, label: "10-99 人", color: "#FFCEA0"},
          {min: 1, max: 9, label: "1-9 人", color: "#FFE7B2"},
          {max: 0, label: "0 人", color: "#E2EBF4"}
        ],
        inRange: {
          symbol: "rect"
          //color: ['#E2EBF4', '#DE1F05']
        },
        itemWidth: 8,
        itemHeight: 20
      }
    ],
    tooltip: {
      trigger: "item"
    },
    toolbox: {
      show: true,
      orient: "verticle",
      left: "right",
      top: "center",
      feature: {
        dataView: {readOnly: false},
        restore: {},
        saveAsImage: {}
      }
    }
  };
  mapOption.series[0].data = data;
  chartFunc(mapOption);
}
