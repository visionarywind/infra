package com.wind.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.wind.util.Holder;

public class SoftReferenceInstance {
    public void start() {

        testLiving(1000);
    }

    public void testLiving(int count) {
        List<WeakReference<byte[]>> weakList = new ArrayList<>(count);
        List<SoftReference<byte[]>> softList = new ArrayList<>(count);
        IntStream.range(0, count).forEach(e -> {
            byte[] weakBytes = new byte[1];
            WeakReference<byte[]> weakRef = new WeakReference<>(weakBytes);
            weakList.add(weakRef);

            byte[] bytes = new byte[10 * 1024 * 1024];
            SoftReference<byte[]> ref = new SoftReference<>(bytes);
            softList.add(ref);
        });

        Holder<Integer> weakEmptyCount = Holder.of(0);
        weakList.forEach(e -> {
            if (e.get() == null) {
                weakEmptyCount.setValue(weakEmptyCount.getValue() + 1);
            }
        });
        Holder<Integer> softEmptyCount = Holder.of(0);
        softList.forEach(e -> {
            if (e.get() == null) {
                softEmptyCount.setValue(softEmptyCount.getValue() + 1);
            }
        });

        System.out.println("weak empty instance : count = " + weakEmptyCount.getValue());
        System.out.println("soft empty instance : count = " + softEmptyCount.getValue());
    }
}
