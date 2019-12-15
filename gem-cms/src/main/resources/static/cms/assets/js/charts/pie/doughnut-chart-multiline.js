new Chart(document.getElementById("multiline-doughnut-chart"), {
    type: 'doughnut',
     data: {
      labels: ["腾讯", "快手", "支付宝", "抖音", "百度"],
      datasets: [{
            label: "用户量 (百万)",
            data: [65, 59, 80, 81, 56],
            backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346"],
        }, {
            label: "用户量 (百万)",
            data: [28, 48, 40, 19, 86],
            backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346"],
        }, {
            label: "用户量 (百万)",
            data: [45, 25, 16, 36, 67],
            backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346"],
        }, {
			label: "用户量 (百万)",
            data: [17, 62, 78, 88, 26],
            backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346"],
        }]
    },
    options: {
	  maintainAspectRatio: false,
	  responsive: true,
      title: {
        display: true,
        text: '2023年预计全网用户量（百万）'
      }
    }
});
