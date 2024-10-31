# 手环管理系统

简单实现了手环管理模块。

🔸**技术路线**：

- Vue v2.*
- ElementUI v2.*

🔸**相关组件**：

- `vuex`：状态管理
- `vue-router`：前端路由
- `axios`：HTTP调用
- `echarts`：图表组件，按需定制
- `i18n`：多语言国际化`vue-i18n`v8.*版本
- `@wangeditor`：富文本编辑器
- `Less`：CSS预处理器/语言


![image.png](../img/b2.png)


---

# Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

# 其他备注

## 资源URL规则：

* `/`   ：基于 `public` 根目录的**绝对路径**
* `../` ：相对路径，上一级路径
* `~`   ：指向模块 `node_modules` 中的资源
* `@`   ：指向 `<projectRoot>/src` 的一个路径别名