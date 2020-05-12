package com.jyh.jiangboot.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author jiangyuhong
 * @date 2019/8/26 20:03
 */
public class SaveFile {

    class ImageFile{
        String fileName;
        byte[] fileBytes;
    }

    /**
     * 将base64字符串解析为字节数组
     * @param s
     * @return
     */
    private ImageFile getByteFromBase64(String s){
        if (s==null||"".equals(s)){
            return null;
        }
        String fimleName="/jiang."+s.substring(s.indexOf("/")+1,s.indexOf(";"));
        s=s.replaceFirst("data:image/.*?;base64,","");
        ImageFile imageFile=new ImageFile();
        imageFile.fileBytes=Base64.getDecoder().decode(s);
        imageFile.fileName=fimleName;
        return imageFile;

    }

    public boolean saveFile() throws IOException {
        ImageFile photoCertFile=getByteFromBase64("data:image/png;base64,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UgDm9ttvrzg/T2zu8R933HHx9NNPx3XXXRcTTzxx3mx6JWjTvXv3uOSSS2L77bevMy9/+Oyzz+KNN96I1157LV599dV47rnn0rJzzTVX3HnnnXmxOq+HHnpozDbbbHWmNeQDx3rRRRfFxx9/nK7FE088USdINeWUU8biiy9e2hQBux49esSGG24YZ555Zml68c3dd98da621Vnz00UfRs2fPNIvvwocfflhcrPSeY5966qlToHLhhReOf/zjH/Vuu7SSbxRQQAEFFFBAAQUUUEABBRRQoGoEqiowRfBin332ibPPPjvOOeecWGeddYKAQy6//PJL/PzzzzH55JPnSem1mClz1113xdprr52yc2aeeeZYbbXVYtppp4377rsvNt988xTwIXOHwrTll18+rrrqqvS5vl8NDUw19/iff/75WHnllWOqqaYKgmA4FAsZUxNNNFGsueaapcljjz12Wi4HrvKMWWedNf71r3/FqquuGvfee286x2233TbPjt9//z1OPPHEePLJJ2OZZZYpTW/Im/79+8f0008fJ598cuyyyy5pFQKKHH8u6623Xtx6662BSY59sjw/XC+OmzLmmGNGp06d0nuWnXPOOWPjjTeOY445Jk0j2PT999/HggsumD7zi+/AHXfckQJw8847b5p+0003pfMlODjNNNOUlvWNAgoooIACCiiggAIKKKCAAgpUr8CwtKMqOEaCFGeddVYKLOyxxx6x2GKLpQygr7/+Oh0dGVMEV+6///4U0GAiQadiueWWW2KppZaKGWaYIU3ef//9U/Bp/fXXT58POOCA0uI77rhjDBkypPSZN7vuumu89NJLdaa988476fOiiy5aZ/r8888fF198cWlac4+fDKPXX389BeTefPPNGH/88eOvv/6KRx99NE3ffffdS5liZIYxn31SyLCiCyNBrVVWWSU4t9122y3NIzBFoOroo49On/nFeROYako577zz0mpbbrllndUJJh1++OGBcQ7+sV8yoIqF486FYyZjiyy3XI499tjgh+tNIXvuqKOOCoJPSy65ZPz6668pMJWX55VAGN+F0047zaypIozvFVBAAQUUUEABBRRQQAEFFKhigaoKTGUnAht06ZpjjjmCIEjOniFjikIWUC4EsjbZZJP0kQDWlVdeGaeffnqe3ehXAkPdunVLgY68MmMpDRo0KMicyoXMrPKugnleU4+frCe6u9ENjywiAjJkJ/Xq1SsIsJ1yyilpF5dddlkcf/zxKYBW7PJX7NKYjyW/kiHF9nPJlvlzY17JVtpggw3qBJPqW5/umHvuuWcKtlVahqy2cccdNx555JHSbAJQZIfl7nx5BhlgdPfje1Fe6Nq56aabJqv6ugqWr+NnBRRQQAEFFFBAAQUUUEABBRRoW4GqCUwxuHgxU4ng01dffZWynehuR2H+VlttFQ899FApc4jpAwYMiAknnDBl2fC5a9euvKSywgor5Ldx0EEHxUILLZQyi/LELbbYIr8tvS699NKlLmpMZEwrgjq52xrTvvvuu3jwwQd5m0pzj5/MqNlnnz0Fv3ImEwO4k/nE+ZCJlMuKK64Ye++9d3DsBMgIYjG+VHYiQ+nggw9OY3XRNZLy1FNPpTGq8jaa+kp3uxdffLEUDGzIdggkFa9DpXXyfLrp/fvf/07ByGLQrdI65dMYS4uufPn7UD7fzwoooIACCiiggAIKKKCAAgooUF0CVROYYtBvutFRCE4wSDljP9Glq7zMN998dSZdf/31wbTzzz+/znQ+ME4TwSgK3dzIuilmC5WPV8VyZE2RtZMLg2/zFLriNJYpluYeP+MqnXDCCWmwcp5cd+GFF6aueOxzxhlnTGNlEagrdou755574n//+19ah7GnDjvssPTUOzK2COwxvhbnPt1006VB44vHm98zSHljSh44vlLW0uOPP56yqBhratJJJ23MZkvL0t1wnHHGiZ133rk0raFvCOxR3nvvvTpjkzV0fZdTQAEFFFBAAQUUUEABBRRQQIFRK1A1gSkGJueHzJ88PhRd+P7zn/8E2Uj1lbnnnjsNpE03N7JuGJupWJjPuEQUAky9e/cuzk5jM9GdrFjIhOLpdrkQECJYRuAnF6blgbeZ1tzjZxvbbbddGtycsaEOOeSQ9JS5SSaZJB0jrwTR8s9kk02Wsoro8sZT+ghM0dXwggsuYFPRt2/fFISjCyJPtquvMAj5EUccUd/s4aa/++67aVqlwBQBITK/6IrIExApdOVraKHbJt0wGUurc+fOdVYjC4oyoiyq/HRBxgQrDppfZ0N+UEABBRRQQAEFFFBAAQUUUECBqhGomsBUfSIEiRhDqjyzKT+hj0AUXbgYk4psKAZMLxaCVRNMMEGadOCBB6bgEtsi+EX2D5k9ZCsVy3777VcnWFPpqXwEzYpd+YrrF9839PjzOhtuuGGsscYaMd5446VMKZ5Kx/hSBKJ22mmnePbZZ+OBBx5IYyldffXVMcYYY+RV09Pvzj333PSZrCXGqCJQRcAolxtvvDEF1HJ2UXEg8rzMiF4HDhyYZldaj26HxcHP6Yr47bffxhRTTDGiTaZ5ZIgRkKJwDgS0/vvf/6bP/GI7lKmnnjoFv9KHsl+YUQgiWhRQQAEFFFBAAQUUUEABBRRQoPoFqj4wBSGBpfKBxglUzDnnnCXhShk8zDzyyCODp+dRGIPp448/ToNtk53DWE3LLLNMmteavxpy/Hn/BHOWXXbZ9HQ5glKMDUVgiswnug+SkcS5v/322yl4ldfj9aKLLkoBNwYCJ5h3xRVXxDnnnBM33HBDaTG62/Fkw7322qs0jTcEvCqNt5UXIoOpT58+6Ql6TCPYVR4szMvmV8Z7ojCg+4gKTx1k/C6exMjx0p2Pp+vR9TKXnDXHtC+++CJPrvOanwSYg251ZvpBAQUUUEABBRRQQAEFFFBAAQWqTmC0CEyRAdPUMYsI8uRBwdHfcsstY80110xZUgREGMeqvBDMIjCSS87AYYD1XJi21FJL5Y8jfG3M8RM4YnBxxoXiiXyU7t27x5AhQ0a4D4IyBHcYIJ7AE8fK0/wIdDFOFYO1U8g0e+KJJ1L3Rz5zDozPRXfGo446ikkVS87MmmWWWdJ8AmMMEj+ikoNJIwtMTTPNNGl8LbptEpgiWMhT/whCLbLIIsE4WFwnAnzLLbdcCrjxZEKMioUufBQDU0UV3yuggAIKKKCAAgoooIACCihQvQJVG5hiTCEyZwgyEJD4/vvv6yiSNTTttNPWmVbpA0+vy0EtuoYRTGE8JoJTZBURFCkvdAnkyXC5EKSiaxnjPuVCoCR3L8vTiq9NPf4rr7wyBWZ69uwZDKhO4T2BoErlm2++SV3lCGjRdS8P9M6y+f0111xTGnuLINlrr72WnjLIMnSzIzBF9tOIMqZYlkJ3uVlnnbW0vdqptb+fe+65NGj7yy+/nIwZj4prN6JxoViTsaF4imAx+Eb3TArdGskWY4D7zTbbLG1/3HHHTeNppQUKv8joYn/FTKvCbN8qoIACCiiggAIKKKCAAgoooECVCVRtYIonynXr1i0N8E0whSe1NaUw5lTO8mF7nTp1SuNQ3XLLLSnoUb5Nus0RrCoOnn3HHXekQM66665bWnyeeeYJgkL1laYc/48//hgEkcgGopDxRPCNcZXqC0yRWcQT7HglO6xSIQspFwJRe+6553Bd+fL8hryyn/vvvz+NaYVnLgTSGGCeQjdLnoiIQ3MKXRe32mqrFAQkkMhYVLlwPRj/a5111kmTHnrooTQAfp7vqwIKKKCAAgoooIACCiiggAIKVLdA1QWmGEeJMuOMMwYBocceeyxlwXz55Zd1JBm/qL5xpYoLkvmUu/IRSGKQ9HvuuSdtnwyhPB5TXicHOfLn+l5nmmmm4Ke8NOf4b7311rQ5Ai533nlnGricpw1WKnTR44cB3AkOkZVUKTOJ4xk8eHBpE3Tlo4sdg6PnQgYU3QUbWvbdd9+45JJLUnCqGHgiqMfg5xSMGcScca6aWrjmdO8jiMhA7wToKF9//XV6T1dMglWUF154IY3HRdaWRQEFFFBAAQUUUEABBRRQQAEFRg+BqgtM0VWM7B+6yuUnvzGta9euJdFdd901nnnmmfSZ8YcaUvr27VvKgiKzhqyfww47LHXZIyNrhx12aMhmRrpMc46fbnx0I6Q7Gsez4IILxm677TbcPgnQMPg43d0I0NHVr75CRtErr7xSZzZdGotPvLv99ttLWUd1FqznA13vCOoRNMuBqWuvvbZ0vViNpwHyRETGiGpKIfsqD0zPkwTpppi7+i2xxBLJiOuWM9tOP/30WGWVVWLxxRdvyu5cRwEFFFBAAQUUUEABBRRQQAEF2kCg6gJTPCmPgEbuIsag3DvttFMdGgbs7lHzpDe6qE0yySR15hGIIWDDYN10WctZNnSJ23333dMA4XnMqZNPPjkIcsw999x1tlH+Yf3114+BAweWT674uTnHzzhKjKdEFheZRgR1cnBugQUWSIOWE6BbffXV4+67705BKYJX5cEfBkHPTyLs3bt36nJX8WD/njjmmGOOaHbFeYceemgaF+qrr75KYzqR4VYsBL7omtiYwnkzJhjXjO6UjOnF0wPz0/94MiBP5GNweAom008/fcoI+/PPP+O4445rzO5cVgEFFFBAAQUUUEABBRRQQAEF2lig09Ca0sbH4O4VUEABBRRQQAEFFFBAAQUUUEABBTqgwBgd8Jw9ZQUUUEABBRRQQAEFFFBAAQUUUECBKhAwMFUFF8FDUEABBRRQQAEFFFBAAQUUUEABBTqigIGpjnjVPWcFFFBAAQUUUEABBRRQQAEFFFCgCgQMTFXBRfAQFFBAAQUUUEABBRRQQAEFFFBAgY4oYGCqI151z1kBBRRQQAEFFFBAAQUUUEABBRSoAgEDU1VwETwEBRRQQAEFFFBAAQUUUEABBRRQoCMKGJjqiFfdc1ZAAQUUUEABBRRQQAEFFFBAAQWqQMDAVBVcBA9BAQUUUEABBRRQQAEFFFBAAQUU6IgCBqY64lX3nBVQQAEFFFBAAQUUUEABBRRQQIEqEDAwVQUXwUNQQAEFFFBAAQUUUEABBRRQQAEFOqKAgamOeNU9ZwUUUEABBRRQQAEFFFBAAQUUUKAKBAxMVcFF8BAUUEABBRRQQAEFFFBAAQUUUECBjihgYKojXnXPWQEFFFBAAQUUUEABBRRQQAEFFKgCgbEGDhxUBYfhISiggAIKKKCAAgoooIACCiiggAIKdDQBM6Y62hX3fBVQQAEFFFBAAQUUUEABBRRQQIEqEeg0tKZUybF4GAoooIACCiiggAIKKKCAAgoooIACHUjAjKkOdLE9VQUUUEABBRRQQAEFFFBAAQUUUKCaBAxMVdPV8FgUUEABBRRQQAEFFFBAAQUUUECBDiRgYKoDXWxPVQEFFFBAAQUUUEABBRRQQAEFFKgmAQNT1XQ1PBYFFFBAAQUUUEABBRRQQAEFFFCgAwkYmOpAF9tTVUABBRRQQAEFFFBAAQUUUEABBapJwMBUNV0Nj0UBBRRQQAEFFFBAAQUUUEABBRToQAIGpjrQxfZUFVBAAQUUUEABBRRQQAEFFFBAgWoSMDBVTVfDY1FAAQUUUEABBRRQQAEFFFBAAQU6kICBqQ50sT1VBRRQQAEFFFBAAQUUUEABBRRQoJoEDExV09XwWBRQQAEFFFBAAQUUUEABBRRQQIEOJGBgqgNdbE9VAQUUUEABBRRQQAEFFFBAAQUUqCYBA1PVdDU8FgUUUEABBRRQQAEFFFBAAQUUUKADCRiY6kAX21NVQAEFFFBAAQUUUEABBRRQQAEFqknAwFQ1XQ2PRQEFFFBAAQUUUEABBRRQQAEFFOhAAgamOtDF9lQVUEABBRRQQAEFFFBAAQUUUECBahIwMFVNV8NjUUABBRRQQAEFFFBAAQUUUEABBTqQgIGpDnSxPVUFFFBAAQUUUEABBRRQQAEFFFCgmgQMTFXT1fBYFFBAAQUUUEABBRRQQAEFFFBAgQ4kYGCqA11sT1UBBRRQQAEFFFBAAQUUUEABBRSoJgEDU9V0NTwWBRRQQAEFFFBAAQUUUEABBRRQoAMJGJjqQBfbU1VAAQUUUEABBRRQQAEFFFBAAQWqScDAVDVdDY9FAQUUUEABBRRQQAEFFFBAAQUU6EACBqY60MX2VBVQQAEFFFBAAQUUUEABBRRQQIFqEjAwVU1Xw2NRQAEFFFBAAQUUUEABBRRQQAEFOpCAgakOdLE91YYL3PpKxLXPj3j5Ib9HPPFu5WXuezPi0qcqz6s09aaXIq5/odKc4ad92T/i6Dsj/vxr2Ly/hkbsek3EW18Om+Y7BRRQQAEFFFBAAQUUUEABBapdYKxqP0CPT4G2EHj4rYj+gyM2W7z+vT/8dsQmF0WcsH7EnitGbH1ZxNcDapcnQPTrHxE3vzxs/Wu2j5i0a8QzH0S88/Ww6by7+ImIMTpFDPqt7vQ5p4pYYqa607qMG3HRk7XbZ9+Ua2qCaL16Rxyzbu1nfyuggAIKKKCAAgoooIACCigwOggYmBodrpLH2KoCBJDOfKjuLl78JOKXmiDRSffVnf6ff0aM+/e/mjXnjbhqu4gt/xcxuGbZbZaKGDCkdnkCRZ99H7Hb8sPW71oTUKI8/1HEfW/Uvs+/+/5Y++66muBSsaw2T93A1IWPR/xRkym13KwRZz8SMXW32qVPuDdirmlqs67GqsmD3Hm54lZ8r4ACCiiggAIKKKCAAgoooEB1CnQaWlOq89A8KgVGjQCZUdPuH7H87BGd/w469f64dt+L9ax9HVITvHrsnYjPT43oNn7d43q2JgNqopppH/eL2PyS2nkEjygEiSibLhZx/ua17/lNd7zf/hz2eb8ba9+f9q9h08YZc1jgKU/tulvE0rNEdP/7GJ6rCXJRlpix9vXbn2sDXwPPq/3sbwUUUEABBRRQQAEFFFBAAQWqWcCMqWq+Oh7bKBW4dKuIKSas3SXjNRGw6rVj7edvarrozXTwsMN575uIN7+o/dxj0oieNT+M8/TgPrXTLqzpmvfhtxGnblT7eayaINOPgyIm7lL7efWzIj6omV9e7q8ZmyqXmSePePXI/GnY62k125y7JjuKsuNVta8Xb1n7yjEtfkLte38roIACCiiggAIKKKCAAgooUO0CBqaq/Qp5fKNMgK5xORuKrnx08Tv1gdrdE6Qqlkdrxpc6q2b572oylFacI2LvlWqyov7Oliout3HNGFS5HLxaTSBp2dpP5QGnba+onX7Z1rWvI/pdKfDE+FIWBRRQQAEFFFBAAQUUUEABBUY3AQNTo9sV83hbTeDtryLGG7t282RIUV79rPb1l99rX/PvnZerHcfpqDsjWI8BynsfGnH1c3mJuq//nDNi3mkjvvopYqFj687j04Bfarv9FTOm8lIvHx4x1UT5U8Sj+w3LmNq9V+3T+S74u5sgg64vV9Pd0KKAAgoooIACCiiggAIKKKDA6CBgYGp0uEoe4ygRILhT3pXv2h1qd13ela/SATHY+ZF3RGy/TN25N75UO2A6gSmeynf3nsPm8/S/Y+6qGXx944hj747YbumIteavnf/RdxEzTjbsmPJaDNQ+2QS1n555v/b1oFtqX7+qGbvKooACCiiggAIKKKCAAgoooMDoImBganS5Uh5nqwuc++iwrnwvf1rzVL6aLKnTH6zdbXlXvhEdTHl21Z9/D4TOOmPXjDW14PS1T9Y7p6YrIEEpxodicPTpukfsck3EgTVd/phO18LnD4kYo9OwvR24at1B08etyfD6q2b7E41Xuwyv89QEwCwKKKCAAgoooIACCiiggAIKjA4CBqZGh6vkMY4Sgec+rHkq399d+fr+WLtLnsRHGVITpBpRSU/xqxn8nEK3vmJ5pGY8qlwG/RrBwOgEvOi+t9AMtUEp5q86d20XvRkOjJigc8STNa95kHO6AD71XsRsU+Yt1b4+WTONMs80ta/5940v1j5lMGdW5em+KqCAAgoooIACCiiggAIKKFBNAgamqulqeCxtIkAwap2a7nMXblEbEOIgyp/KR0CJ8aTGH2f4Q3zh44hVzog4Z9PaeWc/XHeZfjUDpOfCGFIEpQ5bo+apfzWBqYf65Dm1TwE8f7OIOQ6vDVLNNsWweXTrO+HeYZ/zu89rAmh//Fl53jQTD+vyl5f3VQEFFFBAAQUUUEABBRRQQIFqEjAwVU1Xw2NpEwECU3ksqfoOoMu4NU/o22j4uX2+qH0y31n/rgkoTVU7gPlV29Vdrvi0vg0Wilh3gYgxx4g4+f6In2qCU5c+FXH5MxFs64ezIx7fP2KjCyNmObTmuLavzXxaauaagdiPrLtdPu14Ve00ugNaFFBAAQUUUEABBRRQQAEFFBjdBGr+e2xRQIGmCkw/ScRtu9UOWp63Qfc7fuj+t9PVEWQ7zVCzXC4EpSjXPh/x3jcRF9V07Vt/wYjXj64dT2rhHjVBqmMi1qsJYK11Tu1T/9IK/lJAAQUUUEABBRRQQAEFFFCgnQl0GlpT2tk5eToKNFvglc9qBxUnSNTQ0m9gxD2vR2y1ZO0adP97sE/EVN0iFusZ0alT3S3RBZCAVX4SYN25tZ/e+jJizqkrzamdlsevWnGO+pdxjgIKKKCAAgoooIACCiiggALVKmBgqlqvjMelgAIKKKCAAgoooIACCiiggAIKtHMBu/K18wvs6SmggAIKKKCAAgoooIACCiiggALVKmBgqlqvjMelgAIKKKCAAgoooIACCiiggAIKtHMBA1Pt/AJ7egoooIACCiiggAIKKKCAAgoooEC1ChiYqtYr43EpoIACCiiggAIKKKCAAgoooIAC7VzAwFQ7v8CengIKKKCAAgoooIACCiiggAIKKFCtAgamqvXKeFwKKKCAAgoooIACCiiggAIKKKBAOxcwMNXOL7Cnp4ACCiiggAIKKKCAAgoooIACClSrgIGpar0yHpcCCiiggAIKKKCAAgoooIACCijQzgUMTLXzC+zpKaCAAgoooIACCiiggAIKKKCAAtUqMFa1HpjHpUBDBLru1pClXKapAgPPa+qarqeAAgoooIACCiiggAIKKKDAyAXMmBq5kUsooIACCiiggAIKKKCAAgoooIACCrSCgIGpVkB1kwoooIACCiiggAIKKKCAAgoooIACIxcwMDVyI5dQQAEFFFBAAQUUUEABBRRQQAEFFGgFAceYagVUN6lAexH47rvv4pdffokxxxwzxhhjjPjjjz9irLHGij///DM6deqUpjN/4oknji+//DJmnnnm6NOnT8wyyyzx1VdfRbdu3dL6rEP566+/0nZ4pYw99tgxcODAmHTSSaNv375pvXfeeSdmnHHG+Oabb2LCCSeMX3/9Na1T3D/rDx06NMYZZ5z4+eef0/qfffZZzDTTTPHRRx/FdNNNF/369YsuXbqkY2ZZjuH3339P63Aeef+sP9lkk6Xjn2aaadJx83nAgAFpWZZjvc6dO6dzGW+88UrHxDY5/u7du8f3338fk0wySfz4448xwQQTpGVYl2McPHhwmsY2mcdnTFkfv65du6bz4JXPuOA7ZMiQZPDDDz+kc+Sc2Bf7ZF22gQ/HxHrjjjtu6Xx5/9NPP8Xkk0+ezmnqqaeOL774In1mffZB4VrynnNkm1jhM/744yfD6aefPj788MPo2bNnfP7558kKM84rr896+TvBdeKYuHZcQ67lm2++GXPMMUdan+MfNGhQaf/F70T+TuHDcnyn2O+7776bvlt85ruGC/spfify/jFh/fyd7NGjR3z66acx7bTTxrfffpv8OVcKy/7222/p2vLKZ7aZ12f5KaaYIq3HteX64UphG7hzLnzPiteN9xNNNFH6LnAcXAeWYR8U7FgPI+axLKZsGwP88C/fNutmW74TfE8x5hr3798/nQfXDwv2gVP+TrAu15n9sDzXkmuLDd8N1ud8WLf476X4nWA+32/+nXzwwQfp3+snn3wSU001VWn/+d8mlmwLT86Jc+f7zXeY/b711lsx11xzBetzPNm2uD7fw3yd83lzvvk7yd8b/m5wbbhmHCv7Yr38neY4smn+TvJd4Pw5b64x/myf5dgG7/n3zivbwYPjZ32OH/f8b5HjZlmWKX4nOFeuH/NwYB7fAfzZDq9c4/yd4Drx7zJ/b/j+Y806rM8Py/Dd4jpwbTk2SvHY+L7yt3fKKadMf5M4DjzyNWVZ1mMa58t79svf4GzCfjm24nocP8tyffjhvFiOa8814G8uf1+wKf59YRt8F7HklfPgWDgXvnNce64B6/GdrvS3k3NgmxwT26Gwfwy5x7AdTPkOcIz5erMe8/g3mJfBj/kcC+/xzdcpny/b5t8lJnzfsPz666/T36Ti3x5MOA9M+Z5RmMZ+OSdMPqn5fs8wwwzpmnAc7DP/nWF/xb+dTGd+/tvl/dT7KX//+M7nv13eT72f8veLvzn8nfF+Wr33U+7llsYLdKqpIAxt/GquoYACCiiggAIKKKCAAgoooIACCiigQPME7MrXPD/XVkABBRRQQAEFFFBAAQUUUEABBRRoooCBqSbCuZoCCiiggAIKKKCAAgoooIACCiigQPMEDEw1z8+1FVBAAQUUUEABBRRQQAEFFFBAAQWaKGBgqolwrqaAAgoooIACCiiggAIKKKCAAgoo0DwBA1PN83NtBRRQQAEFFFBAAQUUUEABBRRQQIEmChiYaiKcqymggAIKKKCAAgoooIACCiiggAIKNE/AwFTz/FxbAQUUUEABBRRQQAEFFFBAAQUUUKCJAgammgjnagoooIACCiiggAIKKKCAAgoooIACzRMwMNU8P9dWQAEFFFBAAQUUUEABBRRQQAEFFGiigIGpJsK5mgIKKKCAAgoooIACCiiggAIKKKBA8wQMTDXPz7UVUEABBRRQQAEFFFBAAQUUUEABBZooYGCqiXCupoACCiiggAIKKKCAAgoooIACCijQPAEDU83zc20FFFBAAQUUUEABBRRQQAEFFFBAgSYKGJhqIpyrKaCAAgoooIACCiiggAIKKKCAAgo0T8DAVPP8XFsBBRRQQAEFFFBAAQUUUEABBRRQoIkCBqaaCOdqCiiggAIKKKCAAgoooIACCiiggALNEzAw1Tw/11ZAAQUUUEABBRRQQAEFFFBAAQUUaKKAgakmwrmaAgoooIACCiiggAIKKKCAAgoooEDzBAxMNc/PtRVQQAEFFFBAAQUUUEABBRRQQAEFmihgYKqJcK6mgAIKKKCAAgoooIACCiiggAIKKNA8AQNTzfNzbQUUUEABBRRQQAEFFFBAAQUUUECBJgoYmGoinKspoIACCiiggAIKKKCAAgoooIACCjRPwMBU8/xcWwEFFFBAAQUUUEABBRRQQAEFFFCgiQIGppoI52oKKKCAAgoooIACCiiggAIKKKCAAs0TMDDVPD/XVkABBRRQQAEFFFBAAQUUUEABBRRoooCBqSbCuZoCCiiggAIKKKCAAgoooIACCiigQPMEDEw1z8+1FVBAAQUUUEABBRRQQAEFFFBAAQWaKGBgqolwrqaAAgoooIACCiiggAIKKKCAAgoo0DwBA1PN83NtBRRQQAEFFFBAAQUUUEABBRRQQIEmChiYaiKcqymggAIKKKCAAgoooIACCiiggAIKNE/AwFTz/FxbAQUUUEABBRRQQAEFFFBAAQUUUKCJAgammgjnagoooIACCiiggAIKKKCAAgoooIACzRMwMNU8P9dWQAEFFFBAAQUUUEABBRRQQAEFFGiigIGpJsK5mgIKKKCAAgoooIACCiiggAIKKKBA8wQMTDXPz7UVUEABBRRQQAEFFFBAAQUUUEABBZooYGCqiXCupoACCiiggAIKKKCAAgoooIACCijQPAEDU83zc20FFFBAAQUUUEABBRRQQAEFFFBAgSYKGJhqIpyrKaCAAgoooIACCiiggAIKKKCAAgo0T8DAVPP8XFsBBRRQQAEFFFBAAQUUUEABBRRQoIkCBqaaCOdqCiiggAIKKKCAAgoooIACCiiggALNEzAw1Tw/11ZAAQUUUEABBRRQQAEFFFBAAQUUaKKAgakmwrmaAgoooIACCiiggAIKKKCAAgoooEDzBAxMNc/PtRVQQAEFFFBAAQUUUEABBRRQQAEFmihgYKqJcK6mgAIKKKCAAgoooIACCiiggAIKKNA8AQNTzfNzbQUUUEABBRRQQAEFFFBAAQUUUECBJgoYmGoinKspoIACCiiggAIKKKCAAgoooIACCjRPwMBU8/xcWwEFFFBAAQUUUEABBRRQQAEFFFCgiQIGppoI52oKKKCAAgoooIACCiiggAIKKKCAAs0TMDDVPD/XVkABBRRQQAEFFFBAAQUUUEABBRRoooCBqSbCuZoCCiiggAIKKKCAAgoooIACCiigQPMEDEw1z8+1FVBAAQUUUEABBRRQQAEFFFBAAQWaKGBgqolwrqaAAgoooIACCiiggAIKKKCAAgoo0DwBA1PN83NtBRRQQAEFFFBAAQUUUEABBRRQQIEmChiYaiKcqymggAIKKKCAAgoooIACCiiggAIKNE/AwFTz/FxbAQWqRGDgwIHxww8/1PvDfIsCCiiggAIKKNBaAldccUX83//9X8XNn3baadGvX7+K84oT33vvvTj55JPjp59+Kk5u9ff3339/vPnmm6X9/Pnnn/HLL78M91NaoOzN77//Huecc0588sknZXPqfhw8eHAMGjSozg9LfPPNN3HNNdeUFr700kujd+/epc++UUCB9i0wVvs+Pc9OAQVGJwEqJAMGDBjpIXfu3Dm23XbbOssdddRRcdddd9WZVvyw1lprBZXC1ir9+/dPlbepppqqtAsqdX369Invv/8+Fl544ZhggglK8/KbH3/8MV5++eWYbrrpYtZZZ41OnTrlWemVgNprr70W4447biy00EJ15v/888+pIldnhZoPE000UUw22WSlyW+//XaqKDJ9/vnnj/HHH780zzcKKKCAAgoo0DIC1113XfTo0aO0sbvvvjtmmWWWmG222eKSSy6JddZZJyaddNLS/PI3X375ZWy99dbpPr3EEkvUmT3WWGPFkksuWWdaS364/PLLY8UVV4y55547bfamm26Kf//738PtYujQoWnaF198keo9xQUIJhFY22uvvYqTo2vXrjHllFOmacstt1y8+OKLdeZ//vnn8dtvv8UWW2wR8847b8w888yxzz77xG233VZnOT8ooED7FTAw1X6vrWemwGgnQOsggZpcfv3117jxxhtjgw02qBNMGW+88fIidV7/85//xM4771xnGh8uvPDC+OCDD4ab3lITXnjhhSDwteyyy6bjZbsEqqjgvfLKKzH55JPHt99+Gw888ECsvPLKpd1effXVseWWW5bmr7LKKnH77bcHgTfKs88+G+utt15al6AWgaUTTjghVdyYj83222/P2zpl9913T62Wf/31V2y44YapYjfjjDPGRx99lPZ1xx13xOKLL15nHT8ooIACCiigQNMFaIwiW4iGply4z++0004pMJWn1fdKQxbBmLHHHjsmmWSSOO+880qLvv/++6luQL1gVJZlllkmyKSiUI+ab775SrsnaPXUU0+VPuc3r7/+epx77rn5Y3qlLnPrrbem99SZOI899tgjNczRIEd9pWfPnkE9jmwx6lQ0sC2//PJ1tuMHBRRovwIGptrvtfXMFBjtBHbbbbc6x0ygiuDL3nvvnQIqdWZW+PD111+nDKXyWUxvrbLuuusGgZ5pp522zi6ocP3xxx8pFZ+gEtlaBJ5IVSdQRRYTQamrrroqBZqYTlYVmV8nnXRSkOq+8cYbx0orrRRnnXVWCkqdeuqpaZ0VVlghpplmmvjqq69io402imuvvbbOvnPWFcdFayP7mn322YMMKwJ3W221Vbz77rt11vGDAgoooIACCjRN4JFHHon9998/rcx9mfK///0v+vbtG4cddlgpY5rGJBqfyH6655570nI0XHGfv/nmm1Nj1CGHHBITTjhhmscvsqjWXHPNFMgpTWyhN2+99Vaqd7C5J554It555514+OGHY4oppoillloqHWvOsq7UKHjllVemesmIDocg1aOPPpoWweP8889PDWVkSR188MFpOkE4glU50NWrV680vVu3bumYpp566hHtwnkKKNAOBAxMtYOL6CkooEAEXeio+JSnh2cbUsdbo8w111xx8cUXx7HHHlvqVkfWF90SSeHPlct99903BacItJHRRCvqggsuWMp+ohJIUIrWQrZFiyOVNtLhc9o/FdpDDz003njjjVJgioAYrauVypNPPhlrrLFGCkoxnwDZJptsElT4aNkdc8wxK63mNAUUUEABBRRohMAiiywSO+ywQ9xyyy0p02nttdeOIUOGpK78BKjojr/55pune3oxo4pd0HBF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wQQTxIABA/JqQcWP/UwyySTRs2fPFJC64IILYvrpp4/55puvtNzYY48dK620UvpMIGuJJZYozRvZm+eeey4WX3zxkS3mfAUUUEABBTq8wB9//BFvvvlmcnjjjTfigw8+iO7du6fPE000UZx55pnxwAMP1HF67bXXonPnzmlat27d4owzzohZZpklVlhhhdhhhx3i448/rrM8H/75z3/GgQceONz05kzgWKeeeuqgrvXTTz/Vu6nxxx8/Jptssnj55ZfTMi+++GL06dMnJp988vR54oknjkMPPTSoFxXL4MGDY7zxxitO8r0CCigwnICBqeFInKCAAm0pQObTxRdfHDvvvHOMOeaY6VAIwGy66aZx6aWXpiBP+fE99dRTpayj8nn583XXXRefffZZ/thir99++23aN5Wx8847LwhEvf3226kSyk6+/PLLICi0zTbbBIEigkeHHXZYXHHFFdG7d++gwrrLLruk4BQVUUq/fv3i559/jnHGGSdeeeWVdO5pxt+/Lr/88jT9X//6V9oOk6eddtoU5KLVNRe2nQNTBLOoPL7++ut5dumVgBhZWTmoNe+886bgV2kB3yiggAIKKKBAvQLcs8lcLpb8mYYp7sGHHHJIrLfeenHjjTfGbbfdVgpKvf/++6kuwHwa4cgYP+igg9J9ubg9spO+//774qQWeU8wjKDZww8/HKeeemq92yQo1qtXr1RfKS5E4xpl/fXXT+dJEG7rrbeOSy65JNVRDEoVtXyvgAL1CRiYqk/G6Qoo0CYCjz/+eHz33Xex7rrr1tn/lltuGauuumpqhZx55plL8wj8fPPNN6XPld7MPvvsqeWyNQJT7I+gEBWze++9N+3+66+/ThWyk046KWaaaaZYZpllSodFlhSFltQePXrE7rvvniqhjzzySGohZR6BuK222io23HDDmHXWWZlUKiy3/fbbB1lU88wzT2k6LbXTTDNNnWmrr756aT5vCHTl/RdnECSjW2HO6mI5iwIKKKCAAgo0TIBsIRrACDrtv//+aaVPP/00qAfQGLX33nunrKEJJ5ww3fOLdRyyqslQJtuaOgP3dxqWygsZSj/88EP55Bb7fMoppwQ/FLK0OYYXXnghFllkkTr7ePrpp1MdJy9LxtU+++yTMt033njj6NKlS5ABxhAM1N0sCiigQEMEDEw1RMllFFBglAhQEaKiQ+ClvIWNLmu01tGKeNVVVwUp5RRaFsvTxssP9vTTTy+f1OqfCVaNKN1+7bXXDn5IcadSeuGFFzbomPbcc88UBKOr3ZRTTllah4pg165d60wrN2Thvn37xrHHHltajzek5Q8cODB23HHHUnCszgJ+UEABBRRQQIERChCcIrObYQNoECNIRUPPWGMN++8WWdUvvfRSnHDCCcNtiyzxpZdeerjp1TZh0kknTZlVmwm3VPkAAEAASURBVG22Wcq0JjOKLolkhedCXYNs9ssuuyxP8lUBBRQYocCwv5QjXMyZCiigQOsK0IWPVkYCLHR7ozBoOBU40tspxxxzTNB9ba+99grGVKKyR8WIn5GVJ554YmSLNHk+40QceeSRQStiMZurIRs87rjjUlbUGmuskboA5nVI+x9jjOGfT0FG2YcffpjGi6LLYy50x6N19vPPP8+TUnbUHHPMUfrMG4JXCy+8cGnaWWedFW+99VYstdRSaToVa4sCCiiggAIKNFzgiy++SI08ZDLncSXJoKLr3pNPPlna0EMPPRSzzTZbzDDDDKVpo9Mbsqup65BFdfTRR6fue9THyPK+7777Sqdy6623BsMCNLZOVNqAbxRQoMMJGJjqcJfcE1agOgUY9JM09XvuuSdlSxGYIWhCpS4Xur/R+kYK/OGHHx4nnnhimkWlr/wJOMwgo4ixqlq7/Pbbb2lchdwqytPxGtIdjjGpOIdtt902GDi1WOieSJe+8sLAowSm8phSeT7ZWVQA8zhVTGd9nvTXqVOnvFgQeCIzinLzzTcHTzw84IADUtp+nl5a2DcKKKCAAgooMFIBAlN33HFH6v7G03V5v8ACC6Ru8nm8TDYy11xzxfHHH5/GvGTMydGt0AB2zTXXpOEIyPjm/ZJLLhmMk1V8AvFCCy2Uui9SX6F7okUBBRQYmYCBqZEJOV8BBUaJAEEkUuCnmmqqtD+CTaS8M+g5JQdYqMjRlY9xD3JhsHHGWGLgzVyoDFFJGhWBKVoO6R7HQOgUxrJi/KgRFVoYGV+KctNNN6XK6xFHHFFahUoeT8mhglteCDSRGUVXgfJS3m2RpwPNPffc5YsFj7MmEEUmGU7Fp/4Nt7ATFFBAAQUUUKBegUUXXTTdk+kWX14Y25FMbwoBG7LCGbaAzKrRrSy77LIpE6pSnYFxLslqp9AlkXGnyIQne8qigAIKjEzAwNTIhJyvgAKjRGCLLbYo7YdufTwZZo899khjSZGBtNpqq6XsIoJABFrKgy1zzjlnKYjFhkg1Lz6hrrTxUfDmo48+Gm7Q8vLdnnbaaWmwdJ5cc+WVVwZP2qNVlfOgRZIn/NBFkM+0sOZChhMDohcHQOWJemSW5VbMvCyv4447bvFjGlh+t912SwEpBialRbfYyllnYT8ooIACCiigQIME6F7PeEvlpfweS4MbY2byhL1KmdHl61fb55NPPjn4KS/vvfdenUk8lZBMbhrteCqwRQEFFBiRwPADmIxoaecpoIACo0CADCKCLZtssknaGwNq0sJIVhJBq0qFQM27775b+mmtJ/BV2jfp7Oyvf//+aTZPqBlZ6nrv3r1TsI0VeHrNDTfckFoY+/Tpk55kw5hPnDMtkAx0ngutj3RpLP6QZfb888+nCmBxOu8PPfTQvGp6JdOKpx4StGP8B4JgDFBaHLS0zgp+UEABBRRQQIEGCXDfLtZFKq2Un45bbGCqtFw1TyMbikz2/FPpWKm/UKhzWBRQQIGRCRiYGpmQ8xVQYJQKfPzxx2kgcVrjik+VI0jFGE633XbbcMdDYIeubzyxLv+QhTSqxm944IEH0kCmPIGHiiaBtfnnn3+44yxO4Kk2lQpBLQZ7p3KbC4EvKoGMQ3XOOeeUKoJY0ArJAKuUXr16pbGnGIeLMbqoMJ555pl5M+mVDCmeZEg3QcbzYqBW7DbYYIM6y/lBAQUUUEABBVpOgOxvBgwnU3q66aZLjUktt/Xq2RLjbpKZvd");

        byte[] getData = photoCertFile.fileBytes;

        File saveDir = new File("/Users/luv/Desktop/");
        if(!saveDir.exists()){
            saveDir.mkdir();
        }

        File file = new File(saveDir+File.separator+photoCertFile.fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        boolean result = new SaveFile().saveFile();
    }





}