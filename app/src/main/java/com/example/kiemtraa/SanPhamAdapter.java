package com.example.kiemtraa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {
    private Context context;
    private List<SanPham> sanPhamList;

    public SanPhamAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @Override
    public SanPhamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SanPhamViewHolder holder, int position) {
        SanPham sanPham = this.sanPhamList.get(position);
        holder.txtName.setText(sanPham.getTenSP());
        holder.txtPrice.setText(sanPham.getGiaTien().toString());
        Picasso picasso = Picasso.get();
        picasso.load(sanPham.getImage())
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }
    public static  class SanPhamViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPrice;
        ImageView productImage;
        public SanPhamViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
