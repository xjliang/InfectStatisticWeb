function showChinaMap() {
  // let start = $.trim($("#startDate").val());
  let end = $.trim($("#endDate").val());
  let arg = {startDateStr: end, endDateStr: end, dateFormat: "yyyy-MM-dd"};
  let list = selectByTimeRange(arg);

  let mapData = list.map(item => ({
    name: item.provinceName.substring(0, 2),
    value: item.totalConfirmNum
  }));

  let keys = [
    "安徽",
    "北京",
    "重庆",
    "福建",
    "甘肃",
    "广东",
    "广西",
    "贵州",
    "海南",
    "河北",
    "河南",
    "黑龙江",
    "湖北",
    "湖南",
    "吉林",
    "江苏",
    "江西",
    "辽宁",
    "内蒙古",
    "宁夏",
    "青海",
    "山东",
    "山西",
    "陕西",
    "上海",
    "四川",
    "天津",
    "西藏",
    "新疆",
    "云南",
    "浙江",
    "台湾"
  ];

  let arr = [];
  for(var key of keys) {
    var brief = key.substring(0, 2);
    for (var item of mapData) {
      if (brief === item.name) {
        arr.push({
          name: key,
          value: item.value
        });
        break;
      }
    }
  }

  showHide4();
  e4(arr);
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
