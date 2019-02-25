## 项目简介
**项目背景**  

     gralde文件的统一配置，公用代码库的建设，MVVM模式的实际应用建设
**部分代码使用**   

1. BaseFragment的使用方式  
- 无ViewModel时   
```aidl
   public class KnowageDetailActivity extends BaseActivity<NoViewModel, ActivityKnowDetailBinding> {
      @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
    
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_know_detail);
            showContentView();
            }
            
   }
```
- 有具体的ViewModel时
```aidl
public class KnowageDetailActivity extends BaseActivity<KnowageDetailViewModel, ActivityKnowDetailBinding> {
         @Override
                public void onCreate(@Nullable Bundle savedInstanceState) {
            
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_know_detail);
                    showContentView();
                    }
   }
```
2. BaseFragment的部分使用方式
- 无ViewModel时   
```aidl
   public class KnowageFragment extends BaseFragment<NoViewModel, FragmentKnowmainBinding> {
       @Override
         public void onActivityCreated(@Nullable Bundle savedInstanceState) {
             super.onActivityCreated(savedInstanceState);
     
             initView();
             bindingView.mTvTitle.setOnClickListener(v->{
                 KnowageDetailActivity.start(getContext());
             });
         }
     @Override
        public int setContent() {
            return R.layout.fragment_knowmain;
        }
   }
```
- 有具体的ViewModel时
```aidl
public class KnowageFragment extends BaseFragment<KnowageViewModel, FragmentKnowmainBinding> {
        @Override
                public void onActivityCreated(@Nullable Bundle savedInstanceState) {
                    super.onActivityCreated(savedInstanceState);
            
                    initView();
                    bindingView.mTvTitle.setOnClickListener(v->{
                        KnowageDetailActivity.start(getContext());
                    });
                }
            @Override
               public int setContent() {
                   return R.layout.fragment_knowmain;
               }
   }
```