$wnd.com_example_reportingcrb_widgetset_ReportingcrbWidgetset.runAsyncCallback9("function jtb(a){return a.g}\nfunction ltb(a,b){lsb(a,b);--a.i}\nfunction $ad(){GDb.call(this)}\nfunction sKd(){bFb.call(this);this.G=Vre}\nfunction Qn(a){return (cl(),bl).Cc(a,'col')}\nfunction bv(a){var b;b=a.e;if(b){return _u(a,b)}return gp(a.d)}\nfunction wlc(a,b){j1b(a.a,new Rtc(new euc(Nbb),'openPopup'),WD(SD(deb,1),A2d,1,3,[(POd(),b?OOd:NOd)]))}\nfunction ktb(a,b){if(b<0){throw new JOd('Cannot access a row with a negative index: '+b)}if(b>=a.i){throw new JOd(G7d+b+H7d+a.i)}}\nfunction ntb(a,b){if(a.i==b){return}if(b<0){throw new JOd('Cannot set number of rows to '+b)}if(a.i<b){ptb((lkb(),a.G),b-a.i,a.g);a.i=b}else{while(a.i>b){ltb(a,a.i-1)}}}\nfunction otb(a,b){Wrb();rsb.call(this);msb(this,new Lsb(this));psb(this,new aub(this));nsb(this,new Rtb(this));mtb(this,b);ntb(this,a)}\nfunction Qtb(a,b,c){var d,e;b=b>1?b:1;e=a.a.childNodes.length;if(e<b){for(d=e;d<b;d++){Tj(a.a,Qn($doc))}}else if(!c&&e>b){for(d=e;d>b;d--){ak(a.a,a.a.lastChild)}}}\nfunction ptb(a,b,c){var d=$doc.createElement('td');d.innerHTML=qce;var e=$doc.createElement('tr');for(var f=0;f<c;f++){var g=d.cloneNode(true);e.appendChild(g)}a.appendChild(e);for(var h=1;h<b;h++){a.appendChild(e.cloneNode(true))}}\nfunction Zad(a){if((!a.L&&(a.L=QBb(a)),bE(bE(a.L,6),201)).c&&((!a.L&&(a.L=QBb(a)),bE(bE(a.L,6),201)).v==null||vRd('',(!a.L&&(a.L=QBb(a)),bE(bE(a.L,6),201)).v))){return (!a.L&&(a.L=QBb(a)),bE(bE(a.L,6),201)).a}return (!a.L&&(a.L=QBb(a)),bE(bE(a.L,6),201)).v}\nfunction mtb(a,b){var c,d,e,f,g,h,j;if(a.g==b){return}if(b<0){throw new JOd('Cannot set number of columns to '+b)}if(a.g>b){for(c=0;c<a.i;c++){for(d=a.g-1;d>=b;d--){Yrb(a,c,d);e=$rb(a,c,d,false);f=Ztb(a.G,c);f.removeChild(e)}}}else{for(c=0;c<a.i;c++){for(d=a.g;d<b;d++){g=Ztb(a.G,c);h=(j=(lkb(),ro($doc)),Mk(j,qce),lkb(),j);jkb._e(g,Ekb(h),d)}}}a.g=b;Qtb(a.I,b,false)}\nvar Ore='popupVisible',Pre='showDefaultCaption',Qre='setColor',Rre='setOpen',Sre='background',Tre={53:1,7:1,18:1,30:1,37:1,36:1,34:1,35:1,3:1},Ure='com.vaadin.client.ui.colorpicker',Vre='v-colorpicker',kse='v-default-caption-width';Hgb(1,null,{});_.gC=function X(){return this.cZ};Hgb(134,9,v7d);_.Bd=function Npb(a){return qob(this,a,(dv(),dv(),cv))};Hgb(712,29,I7d);_.Bd=function ssb(a){return qob(this,a,(dv(),dv(),cv))};Hgb(731,69,L7d);_.Bd=function ftb(a){return qob(this,a,(dv(),dv(),cv))};Hgb(548,712,I7d,otb);_.Zf=function qtb(a){return jtb(this)};_.$f=function rtb(){return this.i};_._f=function stb(a,b){ktb(this,a);if(b<0){throw new JOd('Cannot access a column with a negative index: '+b)}if(b>=this.g){throw new JOd(E7d+b+F7d+this.g)}};_.ag=function ttb(a){ktb(this,a)};_.g=0;_.i=0;var vL=EPd(n7d,'Grid',548);Hgb(52,502,M7d);_.Bd=function ztb(a){return qob(this,a,(dv(),dv(),cv))};Hgb(389,9,W7d);_.Bd=function xub(a){return rob(this,a,(dv(),dv(),cv))};Hgb(702,36,Tre);_.qh=function _ad(){return false};_.th=function abd(){return !this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)};_.dh=function bbd(){fE(this.vh(),55)&&bE(this.vh(),55).Bd(this)};_.fh=function cbd(a){zDb(this,a);if(a.Mj(Aae)){this.Em();(!this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)).c&&((!this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)).v==null||vRd('',(!this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)).v))&&this.Fm((!this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)).a)}if(a.Mj(uae)||a.Mj(Whe)||a.Mj(Pre)){this.Fm(Zad(this));(!this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)).c&&((!this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)).v==null||!(!this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)).v.length)&&!(!this.L&&(this.L=QBb(this)),bE(bE(this.L,6),201)).J.length?Dnb(this.vh(),kse):Lnb(this.vh(),kse)}};var M4=EPd(Ure,'AbstractColorPickerConnector',702);Hgb(201,6,{6:1,54:1,201:1,3:1},sKd);_.a=null;_.b=false;_.c=false;var Obb=EPd(Tpe,'ColorPickerState',201);p2d(Zh)(9);\n//# sourceURL=com.example.reportingcrb.widgetset.ReportingcrbWidgetset-9.js\n")